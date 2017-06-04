package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="OFFER_CASH_LOAN")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferCashLoan {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double interest;
	@Column(name="INTEREST_TYPE")
	private String interestType;
	@Column(name="MIN_SUM")
	private Double minSum;
	@Column(name="MAX_SUM")
	private Double maxSum;
	@Column(name="MIN_INSTALLMENTS")
	private Integer minInstallments;
	@Column(name="MAX_INSTALLMENTS")
	private Integer maxInstallments;
	private String author;
	@ManyToOne
	@JoinColumn(name="AUTHOR", insertable=false)
	private Manager manager;
	
}
