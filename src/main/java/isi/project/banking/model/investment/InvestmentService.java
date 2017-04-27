package isi.project.banking.model.investment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class InvestmentService {

	EntityManager em;

	public InvestmentService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Investment findInvestment(int id) {
		return em.find(Investment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Investment> findAllInvestments() {
		Query query = em.createQuery("FROM Investment");
		return query.getResultList();
	}
	
	public void createInvestment(Investment investment) {
		try {
			em.getTransaction().begin();
			em.persist(investment);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Error while commiting
			e.printStackTrace();
		}
	}
}
