package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.CashSupervisor;

@Repository
public class CashSupervisorDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(CashSupervisor cashSupervisor) {
		entityManager.persist(cashSupervisor);
	}
	
	@Transactional
	public CashSupervisor findOne(String pesel) {
		return entityManager.find(CashSupervisor.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CashSupervisor> findAll() {
		return entityManager.createQuery("FROM CashSupervisor").getResultList();
	}
	
	@Transactional
	public CashSupervisor update(CashSupervisor cashSupervisor) {
		return entityManager.merge(cashSupervisor);
	}
	
	@Transactional
	public void remove(String pesel) {
		entityManager.remove(findOne(pesel));
	}
}
