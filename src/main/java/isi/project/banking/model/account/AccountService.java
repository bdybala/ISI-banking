package isi.project.banking.model.account;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import isi.project.banking.model.AbstractTransaction;
import isi.project.banking.model.Account;
import isi.project.banking.model.Deposit;
import isi.project.banking.model.Transfer;
import isi.project.banking.model.Withdraw;

public class AccountService {

	
	public static List<AbstractTransaction> getTransactionsFromAccount(Account account) {
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
