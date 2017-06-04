package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="CARD")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	
	@Id
	@Column(name="card_nr")
	private String cardNr;
	@Column(name="acc_nr")
	private String accNr;
	private String name;
	private String status;
	private String cvc;
	private String pin;
	private String nfcValue;
	@ManyToOne
	@JoinColumn(name = "acc_nr", insertable = false, updatable=false)
	private Account account;

}