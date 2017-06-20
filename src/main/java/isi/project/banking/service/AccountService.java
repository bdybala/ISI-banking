package isi.project.banking.service;

import java.util.List;
import java.util.Optional;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Account;

public interface AccountService extends BaseService<AccountDto, String> {

	public void removeByPesel(String pesel) throws EntityNotFoundException;
	public List<AccountDto> findByPesel(String pesel);
	public Optional<AccountDto> save(Account build);
}
