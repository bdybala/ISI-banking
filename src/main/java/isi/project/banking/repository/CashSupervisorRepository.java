package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.CashSupervisor;

public interface CashSupervisorRepository extends JpaRepository<CashSupervisor, String> {

}
