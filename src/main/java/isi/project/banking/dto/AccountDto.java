package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import isi.project.banking.model.Card;
import isi.project.banking.model.CashLoan;
import isi.project.banking.model.Client;
import isi.project.banking.model.Deposit;
import isi.project.banking.model.Investment;
import isi.project.banking.model.MortgageLoan;
import isi.project.banking.model.Transfer;
import isi.project.banking.model.Withdraw;
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
public class AccountDto {

	private String accNr;
	private Double balance;
	private Double dayLimit;
	private Double interest;
	private Date openDate;
	private String pesel;
	private String name;
	
	private Client client;
	
	private Set<Card> cards;
	private Set<CashLoan> cashLoans;
	private Set<MortgageLoan> mortgageLoans;
	private Set<Investment> investments;
	private Set<Transfer> transfersFrom;
	private Set<Transfer> transfersTo;
	private Set<Deposit> deposits;
	private Set<Withdraw> withdrawals;
}
