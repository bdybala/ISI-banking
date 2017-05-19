package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {

}
