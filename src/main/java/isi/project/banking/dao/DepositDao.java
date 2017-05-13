package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Deposit;

@Repository
public class DepositDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void create(Deposit deposit) {
		entityManager.persist(deposit);
	}

	@Transactional
	public Deposit findOne(int id) {
		return entityManager.find(Deposit.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Deposit> findAll() {
		return entityManager.createQuery("FROM Deposit").getResultList();
	}

	@Transactional
	public Deposit update(Deposit deposit) {
		return entityManager.merge(deposit);
	}

	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
