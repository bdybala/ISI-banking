package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Client;

public interface ClientRepository extends JpaRepository<Client, String>{

	public Client findByLoginAndPassword(String login, String password);
}
