package isi.project.banking.dto;

import java.util.Date;
import java.util.Set;

import isi.project.banking.model.CashLoan;
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
public class CashSupervisorDto {
	
	private String pesel;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String nrTel;
	private Date birthday;
	
	private Set<Request> requests;
	private Set<CashLoan> cashLoans;

}
