package isi.project.banking.dto;

import isi.project.banking.model.Manager;
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
public class OfferCashLoanDto {

	private Integer id;
	private String name;
	private Double interest;
	private String interestType;
	private Double minSum;
	private Double maxSum;
	private Integer minInstallments;
	private Integer maxInstallments;
	private String author;

	private Manager manager;
	
}
