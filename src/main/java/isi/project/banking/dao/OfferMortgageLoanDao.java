package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.OfferMortgageLoan;

@Repository
public class OfferMortgageLoanDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(OfferMortgageLoan offerMortgageLoan) {
		entityManager.persist(offerMortgageLoan);
	}
	
	@Transactional
	public OfferMortgageLoan findOne(int id) {
		return entityManager.find(OfferMortgageLoan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<OfferMortgageLoan> findAll() {
		return entityManager.createQuery("FROM OfferMortgageLoan").getResultList();
	}
	
	@Transactional
	public OfferMortgageLoan update(OfferMortgageLoan offerMortgageLoan) {
		return entityManager.merge(offerMortgageLoan);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
