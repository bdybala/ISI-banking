package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.ClientDto;
import isi.project.banking.model.Client;

@Component
public class ClientMapper implements BaseMapper<Client, ClientDto> {
	
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
				.build();
	}

	@Override
	public Client unmap(ClientDto from) {
		return Client.builder()
				.pesel(from.getPesel())
				.login(from.getLogin())
				.password(from.getPassword())
				.firstName(from.getFirstName())
				.lastName(from.getLastName())
				.email(from.getEmail())
				.nrTel(from.getNrTel())
				.birthday(from.getBirthday())
				.build();
	}
	
}
