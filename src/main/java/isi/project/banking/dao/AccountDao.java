package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Account;

@Repository
public class AccountDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Account account) {
		entityManager.persist(account);
	}
	
	@Transactional
	public Account findOne(String accNr) {
		return entityManager.find(Account.class, accNr);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional 
	public List<Account> findByPesel(String pesel) {
		return entityManager.createQuery("FROM Account WHERE pesel=:pesel").
				setParameter("pesel", pesel).
				getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> findAll() {
		return entityManager.createQuery("FROM Account").getResultList();
	}
	
	@Transactional
	public Account update(Account account) {
		return entityManager.merge(account);
	}
	
	@Transactional
	public void remove(String accNr) {
		entityManager.remove(findOne(accNr));
	}
}
