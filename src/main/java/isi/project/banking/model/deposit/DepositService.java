//package isi.project.banking.model.deposit;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//public class DepositService {
//
//	EntityManager em;
//
//	public DepositService(EntityManager em) {
//		super();
//		this.em = em;
//	}
//	
//	public Deposit findOfferInvestment(int id) {
//		return em.find(Deposit.class, id);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Deposit> findAllDeposit() {
//		Query query = em.createQuery("FROM Deposit");
//		return query.getResultList();
//	}
//	
//	public void createDeposit (Deposit deposit) {
//		try {
//			em.getTransaction().begin();
//			em.persist(deposit);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO error while commiting (ORA-error)
//			e.printStackTrace();
//		}
//	}
//}
