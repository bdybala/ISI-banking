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
public class TransferDto extends AbstractTransactionDto {

	private Integer id;
	private double amount;
	private Date orderDate;
	private Date executionDate;
	private String accNrSender;
	private String accNrReceiver;
	private String title;
	
	private AccountDto sender;
	private AccountDto receiver;
	
}
