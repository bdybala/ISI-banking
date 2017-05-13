package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Request;

@Repository
public class RequestDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Request request) {
		entityManager.persist(request);
	}
	
	@Transactional
	public Request findOne(int id) {
		return entityManager.find(Request.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Request> findAll() {
		return entityManager.createQuery("FROM Request").getResultList();
	}
	
	@Transactional
	public Request update(Request request) {
		return entityManager.merge(request);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
