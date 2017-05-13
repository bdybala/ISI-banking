package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Administrator;

@Repository
public class AdministratorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Administrator administrator) {
		entityManager.persist(administrator);
	}
	
	@Transactional
	public Administrator findOne(int id) {
		return entityManager.find(Administrator.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Administrator> findAll() {
		return entityManager.createQuery("FROM Administrator").getResultList();
	}
	
	@Transactional
	public Administrator update(Administrator administrator) {
		return entityManager.merge(administrator);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
