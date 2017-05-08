package isi.project.banking.model.account;

import java.sql.SQLSyntaxErrorException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import isi.project.banking.model.AbstractTransaction;
import isi.project.banking.model.Deposit;
import isi.project.banking.model.Withdraw;
import isi.project.banking.model.transfer.Transfer;

public class AccountService {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();

	public AccountService(EntityManager em) {
		
	}
	public AccountService() {
		
	}
	
	public Account findAccount(String accNr) {
		return em.find(Account.class, accNr);
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> findAccountsByPesel(String pesel) {
		Query query = em.createQuery("FROM Account where pesel=:pesel")
				.setParameter("pesel", pesel);
		return query.getResultList();
	}
	
	public void update(Account account) {
		try {
			em.getTransaction().begin();
			em.merge(account);
			em.getTransaction().commit();
			em.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void createAccount(Account account) {
		try {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Error while commiting
			e.printStackTrace();
		}
	}
	
	public List<AbstractTransaction> getTransactionsFromAccount(Account account) {
		List<AbstractTransaction> allTransactions = new LinkedList<AbstractTransaction>();
		
		for(Transfer transferFrom: account.getTransfersFrom()) {
			allTransactions.add(transferFrom);
		}
		for(Transfer transferTo: account.getTransfersTo()) {
			allTransactions.add(transferTo);
		}
		for(Deposit deposit: account.getDeposits()) {
			allTransactions.add(deposit);
		}
		for(Withdraw withdraw: account.getWithdrawals()) {
			allTransactions.add(withdraw);
		}
		// sort allTransfers by OrderDate
		allTransactions.sort(new Comparator<AbstractTransaction>() {

			@Override
			public int compare(AbstractTransaction o1, AbstractTransaction o2) {
				if(o1.getOrderDate() == null || o2.getOrderDate() == null)
					return 0;
				return o1.getOrderDate().compareTo(o2.getOrderDate());
			}
		});
		
		return allTransactions;
	}
	
}
