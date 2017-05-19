package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Withdraw;

public interface WithdrawRepository extends JpaRepository<Withdraw, Integer> {

}
