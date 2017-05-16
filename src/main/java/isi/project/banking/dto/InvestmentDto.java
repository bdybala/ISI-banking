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
@Entity
@Table(name="INVESTMENT")
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="investment_id_seq_gen")
	@SequenceGenerator(name="investment_id_seq_gen", sequenceName="INVESTMENT_ID_SEQ",allocationSize=1)
	private int id;
	@Column(name="acc_nr")
	private String accNr;
	@Column(name="open_date")
	private Date openDate;
	@Column(name="close_date")
	private Date closeDate;
	private Double interest;
	private Double balance;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ACC_NR", insertable=false)
	private AccountDto account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
