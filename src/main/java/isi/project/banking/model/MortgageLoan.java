package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MORTGAGE_LOAN")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MortgageLoan {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer installments;
	private Double interest;
	private Double sum;
	@Column(name="GRANT_DATE")
	private Date grantDate;
	@Column(name="REPAYMENT_DATE")
	private Date repaymentDate;
	@Column(name="SETTLED_INTEREST")
	private Double settledInterest;
	@Column(name="ACC_NR")
	private String accNr;
	private String provider;
	
	@ManyToOne
	@JoinColumn(name="PROVIDER", insertable=false, updatable=false)
	private MortgageSupervisor mortgageSupervisor;
	@ManyToOne
	@JoinColumn(name="ACC_NR", insertable=false, updatable=false)
	private Account account;
	
}
