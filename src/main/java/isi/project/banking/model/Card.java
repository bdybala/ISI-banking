package isi.project.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="nfc_value")
	private String nfcValue;
	@ManyToOne
	@JoinColumn(name = "acc_nr", insertable = false, updatable=false)
	private Account account;

}