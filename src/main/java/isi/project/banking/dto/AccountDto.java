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
public class AccountDto {

	private String accNr;
	private Double balance;
	private Double dayLimit;
	private Double interest;
	private Date openDate;
	private String pesel;
	private String name;
	
	private ClientDto client;
	
	private List<CardDto> cards;
	private List<CashLoanDto> cashLoans;
	private List<MortgageLoanDto> mortgageLoans;
	private List<InvestmentDto> investments;
	private List<TransferDto> transfersFrom;
	private List<TransferDto> transfersTo;
	private List<DepositDto> deposits;
	private List<WithdrawDto> withdrawals;
	
}
