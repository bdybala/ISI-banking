package isi.project.banking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CASH_SUPERVISOR")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashSupervisor {

	@Id
	private String pesel;
	private String login;
	private String password;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	private String email;
	@Column(name="NR_TEL")
	private String nrTel;
	private Date birthday;
	
	@OneToMany(mappedBy="cashSupervisor")
	private List<Request> requests;
	@OneToMany(mappedBy="provider")
	private List<CashLoan> cashLoans;
	
}
