package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.model.Account;

@Component
public class AccountMapper implements BaseMapper<Account, AccountDto> {

	@Autowired
	ClientMapper clientMapper;
	@Autowired
	CardMapper cardMapper;
	@Autowired
	CashLoanMapper cashLoanMapper;
	@Autowired
	MortgageLoanMapper mortgageLoanMapper;
	@Autowired
	InvestmentMapper investmentMapper;
	@Autowired
	TransferMapper transferMapper;
	@Autowired
	DepositMapper depositMapper;
	@Autowired
	WithdrawMapper withdrawMapper;
	
	@Override
	public AccountDto map(Account from) {
		
		return AccountDto.builder()
				.accNr(from.getAccNr())
				.balance(from.getBalance())
				.dayLimit(from.getDayLimit())
				.interest(from.getInterest())
				.openDate(from.getOpenDate())
				.pesel(from.getPesel())
				.name(from.getName())
				.client(clientMapper.map(from.getClient()))
				.cards(cardMapper.map(from.getCards()))
				.cashLoans(cashLoanMapper.map(from.getCashLoans()))
				.mortgageLoans(mortgageLoanMapper.map(from.getMortgageLoans()))
				.investments(investmentMapper.map(from.getInvestments()))
				.transfersFrom(transferMapper.map(from.getTransfersFrom()))
				.transfersTo(transferMapper.map(from.getTransfersTo()))
				.deposits(depositMapper.map(from.getDeposits()))
				.withdrawals(withdrawMapper.map(from.getWithdrawals()))
				.build();
	}

}
