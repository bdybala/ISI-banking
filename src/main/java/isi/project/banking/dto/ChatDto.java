package isi.project.banking.dto;

import java.util.Set;

import isi.project.banking.model.Message;
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
public class ChatDto {

	private Integer id;

	private Set<Message> messages;
	
}
