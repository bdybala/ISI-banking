package isi.project.banking.dto;

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
	
	private ManagerDto manager;
	private CashSupervisorDto cashSupervisor;
	private MortgageSupervisorDto mortgageSupervisor;
	private AccountDto account;
	
}
