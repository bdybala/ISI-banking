package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.investment.Investment;

@Repository
public class InvestmentDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Investment investment) {
		entityManager.persist(investment);
	}
	
	@Transactional
	public Investment findOne(int id) {
		return entityManager.find(Investment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Investment> findAll() {
		return entityManager.createQuery("from Investment").getResultList();
	}
	
	@Transactional
	public Investment update(Investment investment) {
		return entityManager.merge(investment);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
