package isi.project.banking.model.offerLoan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import isi.project.banking.model.Manager;

@Repository
@Entity
@Table(name="OFFER_CASH_LOAN")
public class OfferCashLoan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double interest;
	@Column(name="INTEREST_TYPE")
	private String interestType;
	@Column(name="MIN_SUM")
	private Double minSum;
	@Column(name="MAX_SUM")
	private Double maxSum;
	@Column(name="MIN_INSTALLMENTS")
	private Integer minInstallments;
	@Column(name="MAX_INSTALLMENTS")
	private Integer maxInstallments;
	private String author;
	@ManyToOne
	@JoinColumn(name="AUTHOR", insertable=false)
	private Manager manager;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public String getInterestType() {
		return interestType;
	}
	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}
	public Double getMinSum() {
		return minSum;
	}
	public void setMinSum(Double minSum) {
		this.minSum = minSum;
	}
	public Double getMaxSum() {
		return maxSum;
	}
	public void setMaxSum(Double maxSum) {
		this.maxSum = maxSum;
	}
	public Integer getMinInstallments() {
		return minInstallments;
	}
	public void setMinInstallments(Integer minInstallments) {
		this.minInstallments = minInstallments;
	}
	public Integer getMaxInstallments() {
		return maxInstallments;
	}
	public void setMaxInstallments(Integer maxInstallments) {
		this.maxInstallments = maxInstallments;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}	
}
