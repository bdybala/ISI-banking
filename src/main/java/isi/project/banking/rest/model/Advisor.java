package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ADVISOR")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {

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
	
	@OneToMany
	private List<Message> messages;
	
}