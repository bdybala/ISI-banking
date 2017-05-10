package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.client.Client;

@Repository
public class ClientDao  {

	@PersistenceContext()
	EntityManager entityManager;
	
	@Transactional
	public Client findOne(String pesel) {
		return entityManager.find(Client.class, pesel);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Client> findAll() {
		return entityManager.createQuery("from Client").getResultList();
	}
	@Transactional
	public Client findByLogin(String login) {
		return (Client) entityManager.createQuery("from Client where login=:login")
				.setParameter("login", login).getSingleResult();
	}
	@Transactional
	public Client findByLoginAndPassword(String login, String password) {
		return (Client) entityManager.createQuery("from Client where login=:login and password=:password")
				.setParameter("login", login).setParameter("password", password)
				.getSingleResult();
	}
	@Transactional
	public void create(Client client) {
		entityManager.persist(client);
	}
	@Transactional
	public Client update(Client client) {
		return entityManager.merge(client);
	}
	
}
