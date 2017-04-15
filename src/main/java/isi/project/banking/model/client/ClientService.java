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
	
	public List<Client> findAllClients() {
		Query query = em.createQuery("FROM Client");
		return (List<Client>) query.getResultList();
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
		
		em.getTransaction().begin();
		em.persist(cl);
		em.getTransaction().commit();
//		em.flush();
		return cl;
	}
}
