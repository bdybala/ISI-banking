package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
