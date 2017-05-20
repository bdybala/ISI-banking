package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import isi.project.banking.dto.ChatDto;
import isi.project.banking.model.Chat;

public class ChatMapper implements BaseMapper<Chat, ChatDto> {

	@Autowired
	MessageMapper messageMapper;
	
	@Override
	public ChatDto map(Chat from) {
		return ChatDto.builder()
				.id(from.getId())
				.messages(messageMapper.map(from.getMessages()))
				.build();
	}

}
