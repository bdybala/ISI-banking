package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {

    Card findByNfcValue(String nfcValue);

}
