package isi.project.banking.model.card;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import isi.project.banking.model.card.Card;

public class CardService {
	
	EntityManager em;

	public CardService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Card findCard(int id)
	{
		return em.find(Card.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Card> findAllCard() {
		Query query = em.createQuery("FROM Card");
		return query.getResultList();
	}
	
	public void createCard (Card card) {
		try {
			em.getTransaction().begin();
			em.persist(card);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO error while commiting (ORA-error)
			e.printStackTrace();
		}
	}
}
