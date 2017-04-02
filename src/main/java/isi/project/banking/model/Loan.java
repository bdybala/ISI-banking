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
@Table(name="LOAN")
public class Loan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="provider_id")
	private int providerId;
	@Column(name="installments")
	private int installments;
	private Double interest;
	private Double sum;
	@Column(name="grant_date")
	private Date grantDate;
	@Column(name="repayment_date")
	private Date repaymentDate;
	private String type;
	@Column(name="settled_interest")
	private Double settledInterest;
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
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Date getGrantDate() {
		return grantDate;
	}
	public void setGrantDate(Date grantDate) {
		this.grantDate = grantDate;
	}
	public Date getRepaymentDate() {
		return repaymentDate;
	}
	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getSettledInterest() {
		return settledInterest;
	}
	public void setSettledInterest(Double settledInterest) {
		this.settledInterest = settledInterest;
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
