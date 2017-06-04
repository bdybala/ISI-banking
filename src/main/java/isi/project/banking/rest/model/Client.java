package isi.project.banking.rest.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
@Entity
@Table(name="CLIENT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

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
	@OneToMany(mappedBy="client", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Message> messages;
	@OneToMany(mappedBy="client", cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Account> accounts;
	
	@Override
	public String toString() {
		return "Client [pesel=" + pesel + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", nrTel=" + nrTel + ", birthday=" + birthday + "]";
	}
}
