package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Integer> {

	public List<Deposit> findByAccountAccNr(String accNr);
}
