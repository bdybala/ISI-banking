package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.TransferDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.TransferMapper;
import isi.project.banking.repository.TransferRepository;
import isi.project.banking.service.TransferService;

@Service
@Primary
public class TransferServiceImpl implements TransferService {

	@Autowired
	TransferRepository transferRepository;
	@Autowired
	TransferMapper transferMapper;
	
	@Override
	public Optional<TransferDto> findOne(Integer id) {
		return Optional.ofNullable(transferMapper.map(transferRepository.findOne(id)));
	}

	@Override
	public List<TransferDto> findAll() {
		return transferMapper.map(transferRepository.findAll());
	}

	@Override
	public List<TransferDto> findBySenderAccNr(String accNr) {
		return transferMapper.map(transferRepository.findBySenderAccNr(accNr));
	}

	@Override
	public List<TransferDto> findByReceiverAccNr(String accNr) {
		return transferMapper.map(transferRepository.findByReceiverAccNr(accNr));
	}
	
	@Override
	public Optional<TransferDto> save(TransferDto transferDto) {
		return Optional.ofNullable(transferMapper.map(transferRepository.save(transferMapper.unmap(transferDto))));
	}

	@Override
	public Optional<TransferDto> update(TransferDto transferDto) {
		// TODO findOne (orElseThrow) than save
		return Optional.ofNullable(transferMapper.map(transferRepository.save(transferMapper.unmap(transferDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		transferRepository.save(transferMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("transfer with that ID not in repo!"))));
	}

}
