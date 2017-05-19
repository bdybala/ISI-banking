package isi.project.banking.dto;

import java.util.Date;
import isi.project.banking.model.Account;
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
public class DepositDto {

	private int id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNr;
	
	private Account account;
}
