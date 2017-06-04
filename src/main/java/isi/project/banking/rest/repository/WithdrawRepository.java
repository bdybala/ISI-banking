package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawRepository extends JpaRepository<Withdraw, Integer> {

	public List<Withdraw> findByAccountAccNr(String accNr);
}
