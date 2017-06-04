package isi.project.banking.rest.repository;

import isi.project.banking.model.CashLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashLoanRepository extends JpaRepository<CashLoan, Integer> {

	List<CashLoan> findByAccountAccNr(String accNr);
	
}
