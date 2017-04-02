package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="DEPOSIT")
public class Deposit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private double balance;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="execution_date")
	private Date executionDate;
	@Column(name="acc_nr")
	private String accNr;
	
	@ManyToOne
	private Account account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
