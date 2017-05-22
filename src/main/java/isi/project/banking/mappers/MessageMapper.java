package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.MessageDto;
import isi.project.banking.model.Message;

@Component
public class MessageMapper implements BaseMapper<Message, MessageDto> {

	@Override
	public MessageDto map(Message from) {
		return MessageDto.builder()
				.id(from.getId())
				.text(from.getText())
				.time(from.getTime())
				.advisorPesel(from.getAdvisorPesel())
				.clientPesel(from.getClientPesel())
				.build();
	}

	@Override
	public Message unmap(MessageDto from) {
		return Message.builder()
				.id(from.getId())
				.text(from.getText())
				.time(from.getTime())
				.advisorPesel(from.getAdvisorPesel())
				.clientPesel(from.getClientPesel())
				.build();	
	}
	
}
