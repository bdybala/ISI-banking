package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="OFFER_INVESTMENT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferInvestment {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double interest;
	@Column(name="INTEREST_TYPE")
	private String interestType;
	private Integer duration;
	@Column(name="MIN_SUM")
	private Double minSum;
	@Column(name="MAX_SUM")
	private Double maxSum;
	private String author;
	@ManyToOne
	@JoinColumn(name="AUTHOR", insertable=false)
	private Manager manager;
	
}
