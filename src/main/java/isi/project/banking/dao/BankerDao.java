package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Banker;

@Repository
public class BankerDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Banker banker) {
		entityManager.persist(banker);
	}
	
	@Transactional
	public Banker findOne(String pesel) {
		return entityManager.find(Banker.class, pesel);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Banker> findAll() {
		return entityManager.createQuery("FROM Banker").getResultList();
	}
	
	@Transactional
	public Banker update(Banker banker) {
		return entityManager.merge(banker);
	}
	
	@Transactional
	public void remove(String pesel) {
		entityManager.remove(findOne(pesel));
	}
}
