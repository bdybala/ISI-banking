package isi.project.banking.rest.repository;

import isi.project.banking.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
