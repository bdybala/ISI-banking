package isi.project.banking.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public abstract class AbstractTransactionDto {

	private Integer id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNrSender;
	private String accNrReceiver;
	
	private AccountDto sender;
	private AccountDto receiver;
	
}
