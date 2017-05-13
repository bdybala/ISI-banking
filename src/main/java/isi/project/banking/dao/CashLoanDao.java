package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.CashLoan;

@Repository
public class CashLoanDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(CashLoan cashLoan) {
		entityManager.persist(cashLoan);
	}
	
	@Transactional
	public CashLoan findOne(int id) {
		return entityManager.find(CashLoan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CashLoan> findAll() {
		return entityManager.createQuery("FROM CashLoan").getResultList();
	}
	
	@Transactional
	public CashLoan update(CashLoan cashLoan) {
		return entityManager.merge(cashLoan);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
