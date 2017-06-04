package isi.project.banking.rest.service.impl;

import isi.project.banking.rest.dto.MobilePaymentDto;
import isi.project.banking.rest.dto.WithdrawDto;
import isi.project.banking.rest.exception.EntityNotFoundException;
import isi.project.banking.rest.exception.InvalidPinException;
import isi.project.banking.rest.exception.NoRequiredFundsException;
import isi.project.banking.rest.mapper.WithdrawMapper;
import isi.project.banking.rest.model.Account;
import isi.project.banking.rest.model.Card;
import isi.project.banking.rest.model.Withdraw;
import isi.project.banking.rest.repository.AccountRepository;
import isi.project.banking.rest.repository.CardRepository;
import isi.project.banking.rest.repository.WithdrawRepository;
import isi.project.banking.rest.service.WithdrawService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Primary
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WithdrawMapper withdrawMapper;

    @Override
    public WithdrawDto executeMobilePayment(MobilePaymentDto mobilePaymentDto)
            throws EntityNotFoundException, InvalidPinException, NoRequiredFundsException {
        // amount tagCode pin

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
