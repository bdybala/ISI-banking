package isi.project.banking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String advisorPesel;
	private String clientPesel;
	@ManyToOne
	private Advisor advisor;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Chat chat;
	
}
