package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
