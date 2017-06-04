package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.MortgageLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MortgageLoanRepository extends JpaRepository<MortgageLoan, Integer> {

	List<MortgageLoan> findByAccountAccNr(String accNr);
	
}
