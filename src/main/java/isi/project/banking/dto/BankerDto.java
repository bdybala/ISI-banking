package isi.project.banking.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankerDto {
	
	private String pesel;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String nrTel;
	private Date birthday;
}
