package isi.project.banking.model.transfer;

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

import isi.project.banking.model.AbstractTransaction;
import isi.project.banking.model.account.Account;

@Repository
@Entity
@Table(name="TRANSFER")
public class Transfer extends AbstractTransaction{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transaction_id_seq_gen")
	@SequenceGenerator(name="transaction_id_seq_gen", sequenceName="TRANSACTION_ID_SEQ",allocationSize=1)
	private Integer id;
	private double amount;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="execution_date")
	private Date executionDate;
	@Column(name="acc_nr_sender")
	private String accNrSender;
	@Column(name="acc_nr_receiver")
	private String accNrReceiver;
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "acc_nr_sender", insertable = false, updatable = false)
	private Account sender;
	@ManyToOne
	@JoinColumn(name = "acc_nr_receiver", insertable = false, updatable = false)
	private Account receiver;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	public Account getReceiver() {
		return receiver;
	}
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
