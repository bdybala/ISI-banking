package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MORTGAGE_SUPERVISOR")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MortgageSupervisor {

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
	
	@OneToMany(mappedBy="mortgageSupervisor")
	private List<Request> requests;
	@OneToMany(mappedBy="provider")
	private List<MortgageLoan> mortgageLoans;
	
}
