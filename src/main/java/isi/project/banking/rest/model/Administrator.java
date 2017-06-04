package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ADMINISTRATOR")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	@Column
	private String login;
	@Column
	private String password;
	
}
