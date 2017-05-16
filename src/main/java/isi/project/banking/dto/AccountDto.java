package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository

public class AccountDto {
	

	private String accNr;
	private Double balance;
	private Double dayLimit;
	private Double interest;

	public AccountDto(String accNr, Double balance, Double dayLimit, Double interest, Date openDate, String pesel,
			String name, Client client) {
		super();
		this.accNr = accNr;
		this.balance = balance;
		this.dayLimit = dayLimit;
		this.interest = interest;
		this.openDate = openDate;
		this.pesel = pesel;
		this.name = name;
		this.client = client;
	}
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
	public Double getDayLimit() {
		return dayLimit;
	}
	public void setDayLimit(Double dayLimit) {
		this.dayLimit = dayLimit;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	private Date openDate;
	private String pesel;
	private String name;
	private Client client;

}
