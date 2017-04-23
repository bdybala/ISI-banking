package isi.project.banking.model.offerLoan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import isi.project.banking.model.offerInvestment.OfferInvestment;

public class OfferMortgageLoanService {

	EntityManager em;
	
	
	public OfferMortgageLoanService(EntityManager em)
	{
		super();
		this.em=em;
	}
	
	public OfferMortgageLoan findOfferMortgageLoan(int id)
	{
		return em.find(OfferMortgageLoan.class, id);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferMortgageLoan> findAllOfferMortgageLoan() {
		Query query = em.createQuery("FROM OfferMortgageLoan");
		return query.getResultList();
	}
	
}
