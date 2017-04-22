package isi.project.banking.model.offerInvestment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OfferInvestmentService {

	EntityManager em;

	public OfferInvestmentService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public OfferInvestment findOfferInvestment(int id) {
		return em.find(OfferInvestment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferInvestment> findAllOfferInvestments() {
		Query query = em.createQuery("FROM OfferInvestment");
		return query.getResultList();
	}
	
	public void createOfferInvestment (OfferInvestment offerInvestment) {
		try {
			em.getTransaction().begin();
			em.persist(offerInvestment);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO error while commiting (ORA-error)
			e.printStackTrace();
		}
	}
}
