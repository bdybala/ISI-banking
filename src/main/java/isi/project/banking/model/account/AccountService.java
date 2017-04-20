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
}
