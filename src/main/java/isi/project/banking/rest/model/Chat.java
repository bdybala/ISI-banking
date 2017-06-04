package isi.project.banking.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CHAT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;

	@OneToMany
	private List<Message> messages;
	
}
