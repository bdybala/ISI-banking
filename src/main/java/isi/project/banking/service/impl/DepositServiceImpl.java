package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.DepositDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.DepositMapper;
import isi.project.banking.repository.DepositRepository;
import isi.project.banking.service.DepositService;

@Service
@Primary
public class DepositServiceImpl implements DepositService {

	@Autowired
	DepositRepository depositRepository;
	@Autowired
	DepositMapper depositMapper;
	
	@Override
	public Optional<DepositDto> findOne(Integer id) {
		return Optional.ofNullable(depositMapper.map(depositRepository.findOne(id)));
	}

	@Override
	public List<DepositDto> findAll() {
		return depositMapper.map(depositRepository.findAll());
	}
	
	@Override
	public List<DepositDto> findByAccountAccNr(String accNr) {
		return depositMapper.map(depositRepository.findByAccountAccNr(accNr));
	}

	@Override
	public Optional<DepositDto> save(DepositDto depositDto) {
		return Optional.ofNullable(depositMapper.map(depositRepository.save(depositMapper.unmap(depositDto))));
	}

	@Override
	public Optional<DepositDto> update(DepositDto depositDto) {
		// TODO findOne (orElseThrow) and than save
		return Optional.ofNullable(depositMapper.map(depositRepository.save(depositMapper.unmap(depositDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		depositRepository.delete(depositMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("Deposit with that ID not in repo!"))));
	}

}
