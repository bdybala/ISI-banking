package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Account;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.service.AccountService;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Optional<Account> findOne(String accNr) {
		return Optional.ofNullable(accountRepository.findOne(accNr));
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> save(Account account) {
		return Optional.ofNullable(accountRepository.save(account));
	}

	@Override
	public Optional<Account> update(Account account) {
		return Optional.ofNullable(accountRepository.save(account));
	}

	@Override
	public void remove(String accNr) throws EntityNotFoundException {
		accountRepository.delete(findOne(accNr).orElseThrow(() 
				-> new EntityNotFoundException("Account with that accNr not found!")));
	}

}
