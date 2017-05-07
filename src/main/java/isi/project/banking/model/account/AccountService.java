package isi.project.banking.model.account;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccountService {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();

	public AccountService(EntityManager em) {
		
	}
	
	public Account findAccount(String accNr) {
		return em.find(Account.class, accNr);
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> findAccountsByPesel(String pesel) {
		Query query = em.createQuery("FROM Account where pesel=:pesel")
				.setParameter("pesel", pesel);
		return query.getResultList();
	}
	
	public void update(Account account) {
		try {
			em.getTransaction().begin();
			em.merge(account);
			em.getTransaction().commit();
			em.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void createAccount(Account account) {
		try {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Error while commiting
			e.printStackTrace();
		}
	}
	
}
