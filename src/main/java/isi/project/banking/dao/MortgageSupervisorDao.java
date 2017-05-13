package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.MortgageSupervisor;

@Repository
public class MortgageSupervisorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(MortgageSupervisor mortgageSupervisor) {
		entityManager.persist(mortgageSupervisor);
	}
	
	@Transactional
	public MortgageSupervisor findOne(String pesel) {
		return entityManager.find(MortgageSupervisor.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<MortgageSupervisor> findAll() {
		return entityManager.createQuery("FROM MortgageSupervisor").getResultList();
	}
	
	@Transactional
	public MortgageSupervisor update(MortgageSupervisor mortgageSupervisor) {
		return entityManager.merge(mortgageSupervisor);
	}
	
	@Transactional
	public void remove(String pesel) {
		entityManager.remove(findOne(pesel));
	}
}
