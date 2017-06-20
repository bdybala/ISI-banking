package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.model.Account;

@Component
public class AccountMapper implements BaseMapper<Account, AccountDto> {

	@Autowired
	ClientMapper clientMapper;
	
	@Override
	public AccountDto map(Account from) {
		
		AccountDto accountDto = AccountDto.builder()
				.accNr(from.getAccNr())
				.balance(from.getBalance())
				.dayLimit(from.getDayLimit())
				.interest(from.getInterest())
				.openDate(from.getOpenDate())
				.name(from.getName())
				.build();
		if(from.getClient() != null) {
			accountDto.setClient(clientMapper.map(from.getClient()));
		}
		
		return accountDto;
	}
	
	@Override
	public Account unmap(AccountDto from) {
		
		
		Account account = Account.builder()
				.accNr(from.getAccNr())
				.balance(from.getBalance())
				.dayLimit(from.getDayLimit())
				.interest(from.getInterest())
				.openDate(from.getOpenDate())
				.name(from.getName())
				.build();
		
		if(from.getClient() != null) {
			account.setClient(clientMapper.unmap(from.getClient()));
		}
		return account;
	}

}
