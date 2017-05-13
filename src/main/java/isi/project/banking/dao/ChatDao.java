package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Chat;

@Repository
public class ChatDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Chat chat) {
		entityManager.persist(chat);
	}
	
	@Transactional
	public Chat findOne(int id) {
		return entityManager.find(Chat.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Chat> findAll() {
		return entityManager.createQuery("FROM Chat").getResultList();
	}
	
	@Transactional
	public Chat update(Chat chat) {
		return entityManager.merge(chat);
	}
	
	@Transactional
	public void remove(int id) {
		entityManager.remove(findOne(id));
	}
}
