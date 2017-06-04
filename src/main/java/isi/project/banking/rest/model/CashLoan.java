package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CASH_LOAN")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashLoan {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
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
	private CashSupervisor cashSupervisor;
	@ManyToOne
	@JoinColumn(name="ACC_NR", insertable=false, updatable=false)
	private Account account;
	
}
