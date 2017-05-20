package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.MessageDto;
import isi.project.banking.model.Message;

@Component
public class MessageMapper implements BaseMapper<Message, MessageDto> {

	@Autowired
	AdvisorMapper advisorMapper;
	@Autowired
	ClientMapper clientMapper;
	@Autowired
	ChatMapper chatMapper;

	@Override
	public MessageDto map(Message from) {
		return MessageDto.builder()
				.id(from.getId())
				.text(from.getText())
				.time(from.getTime())
				.advisorPesel(from.getAdvisorPesel())
				.clientPesel(from.getClientPesel())
				.advisor(advisorMapper.map(from.getAdvisor()))
				.client(clientMapper.map(from.getClient()))
				.chat(chatMapper.map(from.getChat()))
				.build();
	}

}
