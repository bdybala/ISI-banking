package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

	public List<Transfer> findByReceiverAccNr(String accNr);
	public List<Transfer> findBySenderAccNr(String accNr);
}
