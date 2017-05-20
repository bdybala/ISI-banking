package isi.project.banking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private List<Card> cards;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private List<CashLoan> cashLoans;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private List<MortgageLoan> mortgageLoans;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private List<Investment> investments;
	@OneToMany(mappedBy="accNrSender", fetch=FetchType.EAGER)
	private List<Transfer> transfersFrom;
	@OneToMany(mappedBy="accNrReceiver", fetch=FetchType.EAGER)
	private List<Transfer> transfersTo;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private List<Deposit> deposits;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
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
