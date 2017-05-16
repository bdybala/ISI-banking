package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="MANAGER")
public class Manager {

	@Id
	private String pesel;
	private String login;
	private String password;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	private String email;
	@Column(name="NR_TEL")
	private String nrTel;
	private Date birthday;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private Set<OfferCashLoanDto> cashLoanOffers;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private Set<OfferInvestmentDto> investmentOffers;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private Set<OfferMortgageLoanDto> mortgageLoanOffers;
	@OneToMany
	private Set<RequestDto> requests;
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNrTel() {
		return nrTel;
	}
	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Set<OfferCashLoanDto> getCashLoanOffers() {
		return cashLoanOffers;
	}
	public void setCashLoanOffers(Set<OfferCashLoanDto> cashLoanOffers) {
		this.cashLoanOffers = cashLoanOffers;
	}
	public Set<OfferInvestmentDto> getInvestmentOffers() {
		return investmentOffers;
	}
	public void setInvestmentOffers(Set<OfferInvestmentDto> investmentOffers) {
		this.investmentOffers = investmentOffers;
	}
	public Set<OfferMortgageLoanDto> getMortgageLoanOffers() {
		return mortgageLoanOffers;
	}
	public void setMortgageLoanOffers(Set<OfferMortgageLoanDto> mortgageLoanOffers) {
		this.mortgageLoanOffers = mortgageLoanOffers;
	}
	public Set<RequestDto> getRequests() {
		return requests;
	}
	public void setRequests(Set<RequestDto> requests) {
		this.requests = requests;
	}
}
