package isi.project.banking.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Repository;
@Repository

public abstract class AbstractTransactionDto {

	private Integer id;
	private double amount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public AbstractTransactionDto() {
		super();
	}
	public AbstractTransactionDto(Integer id, double amount, Date orderDate, Date executionDate, String accNrSender,
			String accNrReceiver, AccountDto sender, AccountDto receiver) {
		super();
		this.id = id;
		this.amount = amount;
		this.orderDate = orderDate;
		this.executionDate = executionDate;
		this.accNrSender = accNrSender;
		this.accNrReceiver = accNrReceiver;
		this.sender = sender;
		this.receiver = receiver;
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
	private Date orderDate;
	private Date executionDate;
	private String accNrSender;
	private String accNrReceiver;
	
	private AccountDto sender;
	private AccountDto receiver;
	

}
