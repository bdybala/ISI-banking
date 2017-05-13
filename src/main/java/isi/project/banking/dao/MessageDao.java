package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Message;

@Repository
public class MessageDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Message message) {
		entityManager.persist(message);
	}
	
	@Transactional
	public Message findOne(int id) {
		return entityManager.find(Message.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Message> findAll() {
		return entityManager.createQuery("FROM Message").getResultList();
	}
	
	@Transactional
	public Message update(Message message) {
		return entityManager.merge(message);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
