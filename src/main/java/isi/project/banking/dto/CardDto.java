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
public class CardDto {

	private String cardNr;
	private String accNr;
	private String name;
	private String status;
	private String cvc;
	private String pin;

	private AccountDto account;
}
