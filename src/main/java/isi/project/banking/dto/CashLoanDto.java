package isi.project.banking.dto;

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
public class CashLoanDto {

	
	private Integer id;
	private Integer installments;
	private Double interest;
	private Double sum;
	private Date grantDate;
	private Date repaymentDate;
	private Double settledInterest;
	private String accNr;
	private String provider;
	private CashSupervisorDto cashSupervisor;
	private AccountDto account;
	public CashLoanDto(Integer id, Integer installments, Double interest, Double sum, Date grantDate,
			Date repaymentDate, Double settledInterest, String accNr, String provider, CashSupervisorDto cashSupervisor,
			AccountDto account) {
		super();
		this.id = id;
		this.installments = installments;
		this.interest = interest;
		this.sum = sum;
		this.grantDate = grantDate;
		this.repaymentDate = repaymentDate;
		this.settledInterest = settledInterest;
		this.accNr = accNr;
		this.provider = provider;
		this.cashSupervisor = cashSupervisor;
		this.account = account;
	}
	public CashLoanDto() {
		super();
	}
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
	public CashSupervisorDto getCashSupervisor() {
		return cashSupervisor;
	}
	public void setCashSupervisor(CashSupervisorDto cashSupervisor) {
		this.cashSupervisor = cashSupervisor;
	}
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}

}
