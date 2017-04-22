package isi.project.banking.model.client;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ClientService {
	
	
	@PersistenceContext
	EntityManager em;

	public ClientService(EntityManager em) {
		this.em = em;
	}
	
	
	public Client findClient(String pesel) {
		return em.find(Client.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		Query query = em.createQuery("FROM Client");
		return query.getResultList();
	}
	
	
	public Client createClient(
			String pesel,
			String login,
			String password,
			String firstName,
			String lastName,
			String email,
			String nrTel,
			Date birthday) {
		
		Client cl = new Client();
		cl.setPesel(pesel);
		cl.setLogin(login);
		cl.setPassword(password);
		cl.setFirstName(firstName);
		cl.setLastName(lastName);
		cl.setEmail(email);
		cl.setNrTel(nrTel);
		cl.setBirthday(birthday);
		
		try {
			em.getTransaction().begin();
			em.persist(cl);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO error while commiting (e.g. PESEL exists in db)
		}
		return cl;
	}


	public void createClient(Client client) {
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO error while commiting (e.g. PESEL exists in db)			
		}
	}


	public Client findByLogin(String login) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM Client where login=:login")
				.setParameter("login", login);
		return (Client) query.getSingleResult();
	}


	public Client authenticate(String login, String password) {
		Query query = em.createQuery(
				"FROM Client WHERE login=:login AND password=:password")
				.setParameter("login", login).setParameter("password", password);
		return (Client) query.getSingleResult();
	}
}
