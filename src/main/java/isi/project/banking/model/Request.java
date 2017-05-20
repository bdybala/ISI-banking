package isi.project.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="REQUEST")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
