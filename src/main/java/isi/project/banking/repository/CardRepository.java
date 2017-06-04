package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Card;

public interface CardRepository extends JpaRepository<Card, String> {

    Card findByNfcValue(String nfcValue);
}
