package isi.project.banking.model.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AccountService {

	
	EntityManager em;

	public AccountService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Account findAccount(String accNr) {
		return em.find(Account.class, accNr);
	}
	
	public List<Account> findAccountsByPesel(String pesel) {
		Query query = em.createQuery("FROM Account where pesel=:pesel")
				.setParameter("pesel", pesel);
		return query.getResultList();
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
