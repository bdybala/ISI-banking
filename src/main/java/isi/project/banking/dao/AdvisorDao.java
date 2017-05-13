package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Advisor;

@Repository
public class AdvisorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Advisor advisor) {
		entityManager.persist(advisor);
	}
	
	@Transactional
	public Advisor findOne(String pesel) {
		return entityManager.find(Advisor.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Advisor> findAll() {
		return entityManager.createQuery("FROM Advisor").getResultList();
	}
	
	@Transactional
	public Advisor update(Advisor advisor) {
		return entityManager.merge(advisor);
	}
	
	@Transactional
	public void remove(String pesel) {
		entityManager.remove(findOne(pesel));
	}
}
