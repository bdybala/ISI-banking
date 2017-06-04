package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
