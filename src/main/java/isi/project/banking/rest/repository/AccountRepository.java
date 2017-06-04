package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

	public List<Account> findByPesel(String pesel);
}
