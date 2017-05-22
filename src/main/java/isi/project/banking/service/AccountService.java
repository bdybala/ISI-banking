package isi.project.banking.service;

import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Account;

public interface AccountService extends BaseService<Account, String> {

	public void removeByPesel(String pesel) throws EntityNotFoundException;
}
