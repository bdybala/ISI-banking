package isi.project.banking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository()
public class CardDto {

	private String cardNr;
	private String accNr;
	private String name;
	private String status;
	private String cvc;
	private String pin;
	private AccountDto account;
	public CardDto(String cardNr, String accNr, String name, String status, String cvc, String pin,
			AccountDto account) {
		super();
		this.cardNr = cardNr;
		this.accNr = accNr;
		this.name = name;
		this.status = status;
		this.cvc = cvc;
		this.pin = pin;
		this.account = account;
	}
	public CardDto() {
		super();
	}
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
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}

}