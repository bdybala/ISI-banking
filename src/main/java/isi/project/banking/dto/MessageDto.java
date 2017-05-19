package isi.project.banking.dto;

import java.util.Date;
import isi.project.banking.model.Advisor;
import isi.project.banking.model.Chat;
import isi.project.banking.model.Client;
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
public class MessageDto {
	
	private Integer id;
	private String text;
	private Date time;
	private String advisorPesel;
	private String clientPesel;
	
	private Advisor advisor;
	private Client client;
	private Chat chat;

}
