package isi.project.banking.dto;

import java.util.Date;

import isi.project.banking.model.Account;
import isi.project.banking.model.CashSupervisor;
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
public class CashLoanDto {
	
	private Integer id;
	private Integer installments;
	private Double interest;
	private Double sum;
	private Date grantDate;
	private Date repaymentDate;
	private Double settledInterest;
	private String accNr;
	private String provider;
	
	private CashSupervisor cashSupervisor;
	private Account account;

}
