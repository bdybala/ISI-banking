package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.ClientDto;
import isi.project.banking.model.Client;

@Component
public class ClientMapper implements BaseMapper<Client, ClientDto> {
	
	@Autowired
	MessageMapper messageMapper;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public ClientDto map(Client from) {
		return ClientDto.builder()
				.pesel(from.getPesel())
				.login(from.getLogin())
				.password(from.getPassword())
				.firstName(from.getFirstName())
				.lastName(from.getLastName())
				.email(from.getEmail())
				.nrTel(from.getNrTel())
				.birthday(from.getBirthday())
				.messages(messageMapper.map(from.getMessages()))
				.accounts(accountMapper.map(from.getAccounts()))
				.build();
	}

}
