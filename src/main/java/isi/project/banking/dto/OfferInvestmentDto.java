package isi.project.banking.dto;

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

public class OfferInvestmentDto {

	
	private Integer id;
	private String name;
	private Double interest;
	private String interestType;
	private Integer duration;
	private Double minSum;
	private Double maxSum;
	private String author;
	private Manager manager;
	public OfferInvestmentDto(Integer id, String name, Double interest, String interestType, Integer duration,
			Double minSum, Double maxSum, String author, Manager manager) {
		super();
		this.id = id;
		this.name = name;
		this.interest = interest;
		this.interestType = interestType;
		this.duration = duration;
		this.minSum = minSum;
		this.maxSum = maxSum;
		this.author = author;
		this.manager = manager;
	}
	public OfferInvestmentDto() {
		super();
	}
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
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
