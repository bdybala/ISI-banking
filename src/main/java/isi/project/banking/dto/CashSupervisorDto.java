package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository

public class CashSupervisorDto {


	private String pesel;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String nrTel;
	private Date birthday;
	private Set<RequestDto> requests;
	private Set<CashLoanDto> cashLoans;
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
	public Set<RequestDto> getRequests() {
		return requests;
	}
	public void setRequests(Set<RequestDto> requests) {
		this.requests = requests;
	}
	public Set<CashLoanDto> getCashLoans() {
		return cashLoans;
	}
	public void setCashLoans(Set<CashLoanDto> cashLoans) {
		this.cashLoans = cashLoans;
	}
	public CashSupervisorDto(String pesel, String login, String password, String firstName, String lastName,
			String email, String nrTel, Date birthday, Set<RequestDto> requests, Set<CashLoanDto> cashLoans) {
		super();
		this.pesel = pesel;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nrTel = nrTel;
		this.birthday = birthday;
		this.requests = requests;
		this.cashLoans = cashLoans;
	}
	public CashSupervisorDto() {
		super();
	}
	
}
