package isi.project.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Card;

@Repository
public class CardDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void create(Card card) {
		entityManager.persist(card);
	}
	
	@Transactional
	public Card findOne(String cardNr) {
		return entityManager.find(Card.class, cardNr);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Card> findAll() {
		return entityManager.createQuery("FROM Card").getResultList();
	}
	
	@Transactional
	public Card update(Card card) {
		return entityManager.merge(card);
	}
	
	@Transactional
	public void remove(String cardNr) {
		entityManager.remove(findOne(cardNr));
	}
	
}
