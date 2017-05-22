package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {

	List<Investment> findByAccountAccNr(String accNr);
}
