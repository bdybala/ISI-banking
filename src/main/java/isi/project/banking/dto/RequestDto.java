package isi.project.banking.dto;

import javax.persistence.ManyToOne;

import isi.project.banking.model.Account;
import isi.project.banking.model.CashSupervisor;
import isi.project.banking.model.Manager;
import isi.project.banking.model.MortgageSupervisor;
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
public class RequestDto {

	private Integer id;
	private String cause;
	private String accNr;
	private String applicantCash;
	private String applicantMortgage;
	@ManyToOne
	private Manager manager;
	@ManyToOne
	private CashSupervisor cashSupervisor;
	@ManyToOne
	private MortgageSupervisor mortgageSupervisor;
	@ManyToOne
	private Account account;
	
}
