package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MESSAGE")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
