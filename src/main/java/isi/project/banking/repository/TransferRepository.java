package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

	public List<Transfer> findByReceiverAccNr(String accNr);
	public List<Transfer> findBySenderAccNr(String accNr);
}
