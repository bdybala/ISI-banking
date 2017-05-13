package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="CASH_LOAN")
public class CashLoan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer installments;
	private Double interest;
	private Double sum;
	@Column(name="GRANT_DATE")
	private Date grantDate;
	@Column(name="REPAYMENT_DATE")
	private Date repaymentDate;
	@Column(name="SETTLED_INTEREST")
	private Double settledInterest;
	@Column(name="ACC_NR")
	private String accNr;
	private String provider;
	@ManyToOne
	@JoinColumn(name="PROVIDER", insertable=false, updatable=false)
	private CashSupervisor cashSupervisor;
	@ManyToOne
	@JoinColumn(name="ACC_NR", insertable=false, updatable=false)
	private Account account;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
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
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public CashSupervisor getCashSupervisor() {
		return cashSupervisor;
	}
	public void setCashSupervisor(CashSupervisor cashSupervisor) {
		this.cashSupervisor = cashSupervisor;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
