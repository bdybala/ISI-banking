package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.CashLoan;

public interface CashLoanRepository extends JpaRepository<CashLoan, Integer> {

}
