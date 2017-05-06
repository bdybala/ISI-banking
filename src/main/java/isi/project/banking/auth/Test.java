package isi.project.banking.auth;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import isi.project.banking.model.client.Client;

public class Test {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();
	
	public void doSth(Client client) {
		client.setFirstName("changed other way");
		em.getTransaction().begin();
		client = em.merge(client);
		//em.flush();
		em.getTransaction().commit();
		em.close();
		
	}
}
