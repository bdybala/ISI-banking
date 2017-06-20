package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	public List<Account> findByClientPesel(String pesel);
}
