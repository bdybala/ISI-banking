package isi.project.banking.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

public abstract class AbstractTransaction {

	private Integer id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNrSender;
	private String accNrReceiver;
	
	private Account sender;
	private Account receiver;
	
	public Date getOrderDate() {
		return orderDate;
	}
}
