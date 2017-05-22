package isi.project.banking.service;

import java.util.Optional;

import isi.project.banking.dto.ClientDto;

public interface ClientService extends BaseService<ClientDto, String>{

	public Optional<ClientDto> findByLoginAndPassword(String login, String password);
}
