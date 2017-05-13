package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Manager;

@Repository
public class ManagerDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Manager manager) {
		entityManager.persist(manager);
	}
	
	@Transactional
	public Manager findOne(String pesel) {
		return entityManager.find(Manager.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Manager> findAll() {
		return entityManager.createQuery("FROM Manager").getResultList();
	}
	
	@Transactional
	public Manager update(Manager manager) {
		return entityManager.merge(manager);
	}
	
	@Transactional
	public void remove(String pesel) {
		entityManager.remove(findOne(pesel));
	}
}
