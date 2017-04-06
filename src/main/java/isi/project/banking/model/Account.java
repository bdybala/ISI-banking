package isi.project.banking.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

// COMMIT

@Repository
@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	private String accNr;
	private Double balance;
	private String pesel;
	@ManyToOne
	private Person person;
	
	@OneToMany(mappedBy="accNr")
	private Set<Card> cards;
	@OneToMany(mappedBy="accNr")
	private Set<Loan> loans;
	@OneToMany(mappedBy="accNr")
	private Set<Investment> investments;
	@OneToMany(mappedBy="accNrSender")
	private Set<Transfer> transfersFrom;
	@OneToMany(mappedBy="accNrReceiver")
	private Set<Transfer> transfersTo;
	@OneToMany(mappedBy="accNr")
	private Set<Deposit> deposits;
	@OneToMany(mappedBy="accNr")
	private Set<Withdraw> withdrawals;
	
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	public Set<Investment> getInvestments() {
		return investments;
	}
	public void setInvestments(Set<Investment> investments) {
		this.investments = investments;
	}
	public Set<Transfer> getTransfersFrom() {
		return transfersFrom;
	}
	public void setTransfersFrom(Set<Transfer> transfersFrom) {
		this.transfersFrom = transfersFrom;
	}
	public Set<Transfer> getTransfersTo() {
		return transfersTo;
	}
	public void setTransfersTo(Set<Transfer> transfersTo) {
		this.transfersTo = transfersTo;
	}
	public Set<Deposit> getDeposits() {
		return deposits;
	}
	public void setDeposits(Set<Deposit> deposits) {
		this.deposits = deposits;
	}
	public Set<Withdraw> getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(Set<Withdraw> withdrawals) {
		this.withdrawals = withdrawals;
	}
}
