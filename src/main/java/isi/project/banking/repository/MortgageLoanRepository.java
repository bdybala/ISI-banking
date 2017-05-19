package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.MortgageLoan;

public interface MortgageLoanRepository extends JpaRepository<MortgageLoan, Integer> {

}
