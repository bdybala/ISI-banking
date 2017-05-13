package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Transfer;

@Repository
public class TransferDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Transfer transfer) {
		entityManager.persist(transfer);
	}
	
	@Transactional
	public Transfer findOne(int id) {
		return entityManager.find(Transfer.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Transfer> findAll() {
		return entityManager.createQuery("FROM Transfer").getResultList();
	}
	
	@Transactional
	public Transfer update(Transfer transfer) {
		return entityManager.merge(transfer);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
