package isi.project.banking.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository

public class TransferDto extends AbstractTransactionDto{

	private Integer id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNrSender;
	private String accNrReceiver;
	private String title;
	private AccountDto sender;
	private AccountDto receiver;
	public TransferDto(Integer id, double amount, Date orderDate, Date executionDate, String accNrSender,
			String accNrReceiver, String title, AccountDto sender, AccountDto receiver) {
		super();
		this.id = id;
		this.amount = amount;
		this.orderDate = orderDate;
		this.executionDate = executionDate;
		this.accNrSender = accNrSender;
		this.accNrReceiver = accNrReceiver;
		this.title = title;
		this.sender = sender;
		this.receiver = receiver;
	}
	public TransferDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	public String getAccNrSender() {
		return accNrSender;
	}
	public void setAccNrSender(String accNrSender) {
		this.accNrSender = accNrSender;
	}
	public String getAccNrReceiver() {
		return accNrReceiver;
	}
	public void setAccNrReceiver(String accNrReceiver) {
		this.accNrReceiver = accNrReceiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public AccountDto getSender() {
		return sender;
	}
	public void setSender(AccountDto sender) {
		this.sender = sender;
	}
	public AccountDto getReceiver() {
		return receiver;
	}
	public void setReceiver(AccountDto receiver) {
		this.receiver = receiver;
	}

}
