package isi.project.banking.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="MESSAGE")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String text;
	private Date time;
	private String advisorPesel;
	private String clientPesel;
	@ManyToOne
	private AdvisorDto advisor;
	@ManyToOne
	private Client client;
	@ManyToOne
	private ChatDto chat;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAdvisorPesel() {
		return advisorPesel;
	}
	public void setAdvisorPesel(String advisorPesel) {
		this.advisorPesel = advisorPesel;
	}
	public String getClientPesel() {
		return clientPesel;
	}
	public void setClientPesel(String clientPesel) {
		this.clientPesel = clientPesel;
	}
	public AdvisorDto getAdvisor() {
		return advisor;
	}
	public void setAdvisor(AdvisorDto advisor) {
		this.advisor = advisor;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ChatDto getChat() {
		return chat;
	}
	public void setChat(ChatDto chat) {
		this.chat = chat;
	}
}
