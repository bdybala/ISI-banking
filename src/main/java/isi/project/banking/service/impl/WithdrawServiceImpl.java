package isi.project.banking.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import isi.project.banking.dto.MobilePaymentDto;
import isi.project.banking.exceptions.InvalidPinException;
import isi.project.banking.exceptions.NoRequiredFundsException;
import isi.project.banking.model.Account;
import isi.project.banking.model.Card;
import isi.project.banking.model.Withdraw;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.WithdrawMapper;
import isi.project.banking.repository.WithdrawRepository;
import isi.project.banking.service.WithdrawService;

import javax.transaction.Transactional;

@Service
@Primary
public class WithdrawServiceImpl implements WithdrawService {

	@Autowired
	private WithdrawRepository withdrawRepository;
	@Autowired
	private WithdrawMapper withdrawMapper;

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Optional<WithdrawDto> findOne(Integer id) {
		return Optional.ofNullable(withdrawMapper.map(withdrawRepository.findOne(id)));
	}

	@Override
	public List<WithdrawDto> findAll() {
		return withdrawMapper.map(withdrawRepository.findAll());
	}

	@Override
	public List<WithdrawDto> findByAccountAccNr(String accNr) {
		return withdrawMapper.map(withdrawRepository.findByAccountAccNr(accNr));
	}

	@Override
	public Optional<WithdrawDto> save(WithdrawDto withdrawDto) {
		return Optional.ofNullable(withdrawMapper.map(withdrawMapper.unmap(withdrawDto)));
	}

	@Override
	public Optional<WithdrawDto> update(WithdrawDto withdrawDto) {
		// TODO findOne (orElseThrow) and than save
		return Optional.ofNullable(withdrawMapper.map(withdrawMapper.unmap(withdrawDto)));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		withdrawRepository.delete(withdrawMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("Withdraw with that ID not in repo!"))));
	}

	@Override
	public WithdrawDto executeMobilePayment(MobilePaymentDto mobilePaymentDto)
			throws EntityNotFoundException, NoRequiredFundsException, InvalidPinException {

		Card card = Optional.ofNullable(cardRepository.findByNfcValue(mobilePaymentDto.getTagCode())).orElseThrow(()
				-> new EntityNotFoundException("Card with that nfc Value not found! :" + mobilePaymentDto.getTagCode()));

		try {
			verifyAmountAndPin(mobilePaymentDto, card);
			return withdrawMapper.map(executeNewWithdraw(
					Withdraw.builder()
							.accNr(card.getAccNr())
							.amount(mobilePaymentDto.getAmount())
							.orderDate(new Date())
							.executionDate(new Date())
							.build()));
		} catch (InvalidPinException e) {
			throw new InvalidPinException(e);
		}
	}

	private boolean verifyAmountAndPin(MobilePaymentDto mobilePaymentDto, Card card) throws InvalidPinException {
		if (mobilePaymentDto.getAmount() > 50D)
			return mobilePaymentDto.getPin() == card.getPin();
		else
			throw new InvalidPinException("Pin is invalid!");
	}

	@Transactional
	private Withdraw executeNewWithdraw(Withdraw withdraw) throws EntityNotFoundException, NoRequiredFundsException {

		Account account = Optional.ofNullable(accountRepository.findOne(withdraw.getAccNr())).orElseThrow(
				() -> new EntityNotFoundException("Account with that acc nr not found!" + withdraw.getAccNr()));

		if (!accountHasResources(account, withdraw))
			throw new NoRequiredFundsException("No enough funds at account for that withdraw!");

		account.setBalance(account.getBalance() - withdraw.getAmount());
		accountRepository.save(account);
		return withdrawRepository.save(withdraw);
	}

	private boolean accountHasResources(Account account, Withdraw withdraw) {
		return account.getBalance() >= withdraw.getAmount();
	}

}
