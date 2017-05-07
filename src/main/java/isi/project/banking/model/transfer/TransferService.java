package isi.project.banking.model.transfer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import isi.project.banking.model.account.Account;
import isi.project.banking.model.account.AccountService;
import isi.project.banking.model.client.Client;

@Service
public class TransferService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();
	
	public void transfer(Transfer transfer, String pesel) {
		AccountService as = new AccountService(em);
		Account anr = as.findAccount(transfer.getAccNrReceiver());
		Account ans = as.findAccountsByPesel(pesel).get(0);
		transfer.setAccNrSender(ans.getAccNr());
		System.out.println(ans.getPesel());
		ans.setBalance(ans.getBalance() - transfer.getAmount());
		anr.setBalance(anr.getBalance() + transfer.getAmount());
		
		as.update(ans);
		as.update(anr);
		create(transfer);
	}
	
	void create(Transfer t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

}