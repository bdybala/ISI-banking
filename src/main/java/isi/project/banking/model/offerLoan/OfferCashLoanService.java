package isi.project.banking.model.offerLoan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OfferCashLoanService {

	EntityManager em;

	public OfferCashLoanService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public OfferCashLoan findOfferCashLoan(int id) {
		return em.find(OfferCashLoan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferCashLoan> findAllOfferCashLoan() {
		Query query = em.createQuery("FROM OfferCashLoan");
		return query.getResultList();
	}
	
	public void createOfferCashLoan (OfferCashLoan offerCashLoan) {
		try {
			em.getTransaction().begin();
			em.persist(offerCashLoan);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO error while commiting (ORA-error)
			e.printStackTrace();
		}
	}
}