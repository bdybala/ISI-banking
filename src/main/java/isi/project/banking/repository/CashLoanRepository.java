package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.CashLoan;

public interface CashLoanRepository extends JpaRepository<CashLoan, Integer> {

	List<CashLoan> findByAccountAccNr(String accNr);
	
}
