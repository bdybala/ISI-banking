package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Withdraw;

public interface WithdrawRepository extends JpaRepository<Withdraw, Integer> {

	public List<Withdraw> findByAccountAccNr(String accNr);
}
