package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Withdraw;

@Repository
public class WithdrawDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Withdraw Withdraw) {
		entityManager.persist(Withdraw);
	}
	
	@Transactional
	public Withdraw findOne(int id) {
		return entityManager.find(Withdraw.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Withdraw> findAll() {
		return entityManager.createQuery("FROM Withdraw").getResultList();
	}
	
	@Transactional
	public Withdraw update(Withdraw Withdraw) {
		return entityManager.merge(Withdraw);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
