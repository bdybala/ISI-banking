package isi.project.banking.model.transfer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.project.banking.model.Account;
import isi.project.banking.model.Transfer;
import isi.project.banking.repository.AccountRepository;

@Service
public class TransferService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();
	
	@Autowired
	AccountRepository accountRepository;
	
	public void transfer(Transfer transfer, String pesel) {
		
		Account anr = accountRepository.findOne(transfer.getAccNrReceiver());
		Account ans = accountRepository.findByPesel(pesel);
		transfer.setAccNrSender(ans.getAccNr());
		System.out.println(ans.getPesel());
		ans.setBalance(ans.getBalance() - transfer.getAmount());
		anr.setBalance(anr.getBalance() + transfer.getAmount());
		
		accountRepository.save(ans);
		accountRepository.save(anr);
		create(transfer);
	}
	
	void create(Transfer t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

}