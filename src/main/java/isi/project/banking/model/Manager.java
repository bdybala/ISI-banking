package isi.project.banking.model;

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
	private Set<OfferCashLoan> cashLoanOffers;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private Set<OfferInvestment> investmentOffers;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private Set<OfferMortgageLoan> mortgageLoanOffers;
	@OneToMany
	private Set<Request> requests;
	
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
	public Set<OfferCashLoan> getCashLoanOffers() {
		return cashLoanOffers;
	}
	public void setCashLoanOffers(Set<OfferCashLoan> cashLoanOffers) {
		this.cashLoanOffers = cashLoanOffers;
	}
	public Set<OfferInvestment> getInvestmentOffers() {
		return investmentOffers;
	}
	public void setInvestmentOffers(Set<OfferInvestment> investmentOffers) {
		this.investmentOffers = investmentOffers;
	}
	public Set<OfferMortgageLoan> getMortgageLoanOffers() {
		return mortgageLoanOffers;
	}
	public void setMortgageLoanOffers(Set<OfferMortgageLoan> mortgageLoanOffers) {
		this.mortgageLoanOffers = mortgageLoanOffers;
	}
	public Set<Request> getRequests() {
		return requests;
	}
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}
}
