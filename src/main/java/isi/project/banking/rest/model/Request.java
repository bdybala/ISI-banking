package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="REQUEST")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String cause;
	@Column(name="ACC_NR")
	private String accNr;
	@Column(name="APPLICANT_CASH")
	private String applicantCash;
	@Column(name="APPLICANT_MORTGAGE")
	private String applicantMortgage;
	@ManyToOne
	private Manager manager;
	@ManyToOne
	private CashSupervisor cashSupervisor;
	@ManyToOne
	private MortgageSupervisor mortgageSupervisor;
	@ManyToOne
	private Account account;
	
}
