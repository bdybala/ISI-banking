package isi.project.banking.dto;

import java.util.Date;
import java.util.List;

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
	
	private List<OfferCashLoanDto> cashLoanOffers;
	private List<OfferInvestmentDto> investmentOffers;
	private List<OfferMortgageLoanDto> mortgageLoanOffers;
	private List<RequestDto> requests;
	
}
