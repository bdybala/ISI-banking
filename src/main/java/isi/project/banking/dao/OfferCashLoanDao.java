package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.offerLoan.OfferCashLoan;

@Repository
public class OfferCashLoanDao {


	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(OfferCashLoan offerCashLoan) {
		entityManager.persist(offerCashLoan);
	}
	
	@Transactional
	public OfferCashLoan findOne(int id) {
		return entityManager.find(OfferCashLoan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<OfferCashLoan> findAll() {
		return entityManager.createQuery("FROM OfferCashLoan").getResultList();
	}
	
	@Transactional
	public OfferCashLoan update(OfferCashLoan offerCashLoan) {
		return entityManager.merge(offerCashLoan);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
