package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.MortgageLoan;

public interface MortgageLoanRepository extends JpaRepository<MortgageLoan, Integer> {

	List<MortgageLoan> findByAccountAccNr(String accNr);
	
}
