package isi.project.banking.model.transfer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.project.banking.dao.AccountDao;
import isi.project.banking.model.account.Account;

@Service
public class TransferService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
	EntityManager em = emf.createEntityManager();
	
	@Autowired
	AccountDao accountDao;
	public void transfer(Transfer transfer, String pesel) {
		
		Account anr = accountDao.findOne(transfer.getAccNrReceiver());
		Account ans = accountDao.findByPesel(pesel).get(0);
		transfer.setAccNrSender(ans.getAccNr());
		System.out.println(ans.getPesel());
		ans.setBalance(ans.getBalance() - transfer.getAmount());
		anr.setBalance(anr.getBalance() + transfer.getAmount());
		
		accountDao.update(ans);
		accountDao.update(anr);
		create(transfer);
	}
	
	void create(Transfer t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

}