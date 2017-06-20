package isi.project.banking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String name;
	@ManyToOne
	@JoinColumn(name = "PESEL")
	private Client client;
	
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Card> cards;
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CashLoan> cashLoans;
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<MortgageLoan> mortgageLoans;
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Investment> investments;
	@OneToMany(mappedBy="accNrSender", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Transfer> transfersFrom;
	@OneToMany(mappedBy="accNrReceiver", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Transfer> transfersTo;
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Deposit> deposits;
	@OneToMany(mappedBy="accNr", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Withdraw> withdrawals;
	
}
