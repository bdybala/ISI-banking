package isi.project.banking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MANAGER")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	@OneToMany(mappedBy="manager")
	private List<OfferCashLoan> cashLoanOffers;
	@OneToMany(mappedBy="manager")
	private List<OfferInvestment> investmentOffers;
	@OneToMany(mappedBy="manager")
	private List<OfferMortgageLoan> mortgageLoanOffers;
	@OneToMany
	private List<Request> requests;
	
}
