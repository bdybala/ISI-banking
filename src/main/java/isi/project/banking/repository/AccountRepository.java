package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	public Account findByPesel(String pesel);
}
