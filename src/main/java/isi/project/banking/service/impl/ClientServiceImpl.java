package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Client;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.ClientService;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Optional<Client> findOne(String pesel) {
		return Optional.ofNullable(clientRepository.findOne(pesel));
	}
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	@Override
	public Optional<Client> save(Client client) {
		return Optional.ofNullable(clientRepository.save(client));
	}
	@Override
	public Optional<Client> update(Client client) {
		return Optional.ofNullable(clientRepository.save(client));
	}
	@Override
	@Transactional
	public void remove(String pesel) throws EntityNotFoundException {
		clientRepository.delete(findOne(pesel).orElseThrow(() 
				-> new EntityNotFoundException("Client with that pesel not found!")));
	}
}
