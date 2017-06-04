package isi.project.banking.rest.repository;

import isi.project.banking.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {

	List<Investment> findByAccountAccNr(String accNr);
}
