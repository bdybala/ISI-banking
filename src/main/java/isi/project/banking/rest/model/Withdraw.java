package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="WITHDRAW")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Withdraw extends AbstractTransaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="transaction_id_seq_gen")
	@SequenceGenerator(name="transaction_id_seq_gen", sequenceName="TRANSACTION_ID_SEQ",allocationSize=1)
	private int id;
	@Column(name="amount")
	private double amount;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="execution_date")
	private Date executionDate;
	@Column(name="acc_nr")
	private String accNr;
	@ManyToOne
	@JoinColumn(name="ACC_NR", updatable=false, insertable=false)
	private Account account;
	
}
