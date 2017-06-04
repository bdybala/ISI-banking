package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
