package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import isi.project.banking.model.OfferCashLoan;
import isi.project.banking.model.OfferInvestment;
import isi.project.banking.model.OfferMortgageLoan;
import isi.project.banking.model.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDto {

	private String pesel;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String nrTel;
	private Date birthday;
	
	private Set<OfferCashLoan> cashLoanOffers;
	private Set<OfferInvestment> investmentOffers;
	private Set<OfferMortgageLoan> mortgageLoanOffers;
	private Set<Request> requests;
	
}
