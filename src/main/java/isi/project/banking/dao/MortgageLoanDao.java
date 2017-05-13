package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.MortgageLoan;

@Repository
public class MortgageLoanDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(MortgageLoan mortgageLoan) {
		entityManager.persist(mortgageLoan);
	}
	
	@Transactional
	public MortgageLoan findOne(int id) {
		return entityManager.find(MortgageLoan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<MortgageLoan> findAll() {
		return entityManager.createQuery("FROM MortgageLoan").getResultList();
	}
	
	@Transactional
	public MortgageLoan update(MortgageLoan mortgageLoan) {
		return entityManager.merge(mortgageLoan);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
