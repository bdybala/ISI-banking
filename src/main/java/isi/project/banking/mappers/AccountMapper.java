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
		
		return AccountDto.builder()
				.accNr(from.getAccNr())
				.balance(from.getBalance())
				.dayLimit(from.getDayLimit())
				.interest(from.getInterest())
				.openDate(from.getOpenDate())
				.pesel(from.getPesel())
				.name(from.getName())
				.client(clientMapper.map(from.getClient()))
				.build();
	}
	
	@Override
	public Account unmap(AccountDto from) {
		
		return Account.builder()
				.accNr(from.getAccNr())
				.balance(from.getBalance())
				.dayLimit(from.getDayLimit())
				.interest(from.getInterest())
				.openDate(from.getOpenDate())
				.pesel(from.getPesel())
				.name(from.getName())
				.client(clientMapper.unmap(from.getClient()))
				.build();
	}

}
