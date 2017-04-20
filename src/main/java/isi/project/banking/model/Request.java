package isi.project.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.account.Account;

@Repository
@Entity
@Table(name="REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String cause;
	@Column(name="ACC_NR")
	private String accNr;
	@Column(name="APPLICANT_CASH")
	private String applicantCash;
	@Column(name="APPLICANT_MORTGAGE")
	private String applicantMortgage;
	@ManyToOne
	private Manager manager;
	@ManyToOne
	private CashSupervisor cashSupervisor;
	@ManyToOne
	private MortgageSupervisor mortgageSupervisor;
	@ManyToOne
	private Account account;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public String getApplicantCash() {
		return applicantCash;
	}
	public void setApplicantCash(String applicantCash) {
		this.applicantCash = applicantCash;
	}
	public String getApplicantMortgage() {
		return applicantMortgage;
	}
	public void setApplicantMortgage(String applicantMortgage) {
		this.applicantMortgage = applicantMortgage;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public CashSupervisor getCashSupervisor() {
		return cashSupervisor;
	}
	public void setCashSupervisor(CashSupervisor cashSupervisor) {
		this.cashSupervisor = cashSupervisor;
	}
	public MortgageSupervisor getMortgageSupervisor() {
		return mortgageSupervisor;
	}
	public void setMortgageSupervisor(MortgageSupervisor mortgageSupervisor) {
		this.mortgageSupervisor = mortgageSupervisor;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
