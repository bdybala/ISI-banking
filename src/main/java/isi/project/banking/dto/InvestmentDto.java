package isi.project.banking.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvestmentDto {

	private int id;
	private String accNr;
	private Date openDate;
	private Date closeDate;
	private Double interest;
	private Double balance;
	private String name;
	
	private AccountDto account;
	
}
