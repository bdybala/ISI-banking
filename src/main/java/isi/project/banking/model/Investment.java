package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="INVESTMENT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="investment_id_seq_gen")
	@SequenceGenerator(name="investment_id_seq_gen", sequenceName="INVESTMENT_ID_SEQ",allocationSize=1)
	private int id;
	@Column(name="acc_nr")
	private String accNr;
	@Column(name="open_date")
	private Date openDate;
	@Column(name="close_date")
	private Date closeDate;
	private Double interest;
	private Double balance;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ACC_NR", insertable=false)
	private Account account;
	
}
