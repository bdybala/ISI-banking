package isi.project.banking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository

public class RequestDto {

	
	private Integer id;
	private String cause;
	private String accNr;
	private String applicantCash;
	private String applicantMortgage;
	private Manager manager;
	private CashSupervisorDto cashSupervisor;
	private MortgageSupervisorDto mortgageSupervisor;
	private AccountDto account;
	public RequestDto(Integer id, String cause, String accNr, String applicantCash, String applicantMortgage,
			Manager manager, CashSupervisorDto cashSupervisor, MortgageSupervisorDto mortgageSupervisor,
			AccountDto account) {
		super();
		this.id = id;
		this.cause = cause;
		this.accNr = accNr;
		this.applicantCash = applicantCash;
		this.applicantMortgage = applicantMortgage;
		this.manager = manager;
		this.cashSupervisor = cashSupervisor;
		this.mortgageSupervisor = mortgageSupervisor;
		this.account = account;
	}
	public RequestDto() {
		super();
	}
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
	public CashSupervisorDto getCashSupervisor() {
		return cashSupervisor;
	}
	public void setCashSupervisor(CashSupervisorDto cashSupervisor) {
		this.cashSupervisor = cashSupervisor;
	}
	public MortgageSupervisorDto getMortgageSupervisor() {
		return mortgageSupervisor;
	}
	public void setMortgageSupervisor(MortgageSupervisorDto mortgageSupervisor) {
		this.mortgageSupervisor = mortgageSupervisor;
	}
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
}
