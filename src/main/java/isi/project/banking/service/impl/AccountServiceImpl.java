package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.AccountMapper;
import isi.project.banking.model.Account;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.service.AccountService;

@Service("AccountService")
@Primary
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public Optional<AccountDto> findOne(String accNr) {
		return Optional.ofNullable(accountMapper.map(accountRepository.findOne(accNr)));
	}
	
	@Override
	public List<AccountDto> findByPesel(String pesel) {
		return accountMapper.map(accountRepository.findByClientPesel(pesel));
	}

	@Override
	public List<AccountDto> findAll() {
		return accountMapper.map(accountRepository.findAll());
	}

	@Override
	public Optional<AccountDto> save(AccountDto accountDto) {
		return Optional.ofNullable(accountMapper.map(accountRepository.save(accountMapper.unmap(accountDto))));
	}

	@Override
	public Optional<AccountDto> update(AccountDto accountDto) {
		//TODO first findOne in repo, (orElseThrow) than save
		return Optional.ofNullable(accountMapper.map(accountRepository.save(accountMapper.unmap(accountDto))));
	}

	@Override
	@Transactional
	public void remove(String accNr) throws EntityNotFoundException {
		accountRepository.delete(accountMapper.unmap(findOne(accNr).orElseThrow(() 
				-> new EntityNotFoundException("Account with that accNr not found!"))));
	}

	@Override
	public void removeByPesel(String pesel) throws EntityNotFoundException {
		// TODO nie wiem czy jest sens jeszce, trzeba rozkminiæ
		
	}

	@Override
	public Optional<AccountDto> save(Account account) {
		return Optional.ofNullable(accountMapper.map(accountRepository.save(account)));
	}
	
}
