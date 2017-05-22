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
	
}
