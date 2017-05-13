package isi.project.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository()
@Entity
@Table(name="CARD")
public class Card {
	
	@Id
	@Column(name="card_nr")
	private String cardNr;
	@Column(name="acc_nr")
	private String accNr;
	private String name;
	private String status;
	private String cvc;
	private String pin;
	@ManyToOne
	@JoinColumn(name = "acc_nr", insertable = false, updatable=false)
	private Account account;

	public String getCardNr() {
		return cardNr;
	}
	public void setCardNr(String cardNr) {
		this.cardNr = cardNr;
	}
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}