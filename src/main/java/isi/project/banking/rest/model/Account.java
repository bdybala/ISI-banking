package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ACCOUNT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@Column(name = "ACC_NR")
	private String accNr;
	private Double balance;
	@Column(name = "DAY_LIMIT")
	private Double dayLimit;
	private Double interest;
	@Column(name = "OPEN_DATE")
	private Date openDate;
	private String pesel;
	private String name;
	@ManyToOne
	@JoinColumn(name = "PESEL", insertable = false, updatable = false)
	private Client client;
	
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Card> cards;
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<CashLoan> cashLoans;
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<MortgageLoan> mortgageLoans;
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Investment> investments;
	@OneToMany(mappedBy="accNrSender", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Transfer> transfersFrom;
	@OneToMany(mappedBy="accNrReceiver", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Transfer> transfersTo;
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Deposit> deposits;
	@OneToMany(mappedBy="accNr", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Withdraw> withdrawals;
	
	public Account(String pesel, String name) {
		super();
		this.pesel = pesel;
		this.name = name;
		
		// default values:
		this.accNr = "";
		this.balance = 0.;
		this.dayLimit = 0.;
		this.interest = 0.;
		this.openDate = new Date();
	}
}
