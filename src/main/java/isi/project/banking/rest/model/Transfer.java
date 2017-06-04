package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TRANSFER")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer extends AbstractTransaction{
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="transaction_id_seq_gen")
	@SequenceGenerator(name="transaction_id_seq_gen", sequenceName="TRANSACTION_ID_SEQ",allocationSize=1)
	private Integer id;
	private double amount;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="execution_date")
	private Date executionDate;
	@Column(name="acc_nr_sender")
	private String accNrSender;
	@Column(name="acc_nr_receiver")
	private String accNrReceiver;
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "acc_nr_sender", insertable = false, updatable = false)
	private Account sender;
	@ManyToOne
	@JoinColumn(name = "acc_nr_receiver", insertable = false, updatable = false)
	private Account receiver;
	
}
