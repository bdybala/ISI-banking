package isi.project.banking.dto;

import java.util.Date;
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
public class WithdrawDto {

	private int id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNr;

	private AccountDto account;
	
}
