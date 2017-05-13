package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.offerInvestment.OfferInvestment;

@Repository
public class OfferInvestmentDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(OfferInvestment offerInvestment) {
		entityManager.persist(offerInvestment);
	}
	
	@Transactional
	public OfferInvestment findOne(int id) {
		return entityManager.find(OfferInvestment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<OfferInvestment> findAll() {
		return entityManager.createQuery("FROM OfferInvestment").getResultList();
	}
	
	@Transactional
	public OfferInvestment update(OfferInvestment offerInvestment) {
		return entityManager.merge(offerInvestment);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
	
}
