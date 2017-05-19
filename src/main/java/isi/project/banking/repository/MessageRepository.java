package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
