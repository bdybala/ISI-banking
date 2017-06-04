package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MESSAGE")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String text;
	private Date time;
	@Column(name="advisor_pesel")
	private String advisorPesel;
	@Column(name="client_pesel")
	private String clientPesel;
	@Column(name="chat_id")
	private Integer chatId;
	@ManyToOne
	@JoinColumn(name="advisor_pesel", insertable=false, updatable=false)
	private Advisor advisor;
	@ManyToOne
	@JoinColumn(name="client_pesel", insertable=false, updatable=false)
	private Client client;
	@ManyToOne
	@JoinColumn(name="chat_id", insertable=false, updatable=false)
	private Chat chat;
	
}
