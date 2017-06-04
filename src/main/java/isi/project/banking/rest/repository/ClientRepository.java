package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

	public Client findByLoginAndPassword(String login, String password);
}
