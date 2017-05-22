package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.InvestmentDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.InvestmentMapper;
import isi.project.banking.repository.InvestmentRepository;
import isi.project.banking.service.InvestmentService;

@Service
@Primary
public class InvestmentServiceImpl implements InvestmentService {

	@Autowired
	InvestmentRepository investmentRepository;
	@Autowired
	InvestmentMapper investmentMapper;
	
	@Override
	public Optional<InvestmentDto> findOne(Integer id) {
		return Optional.ofNullable(investmentMapper.map(investmentRepository.findOne(id)));
	}

	@Override
	public List<InvestmentDto> findAll() {
		return investmentMapper.map(investmentRepository.findAll());
	}
	
	@Override
	public List<InvestmentDto> findByAccountAccNr(String accNr) {
		return investmentMapper.map(investmentRepository.findByAccountAccNr(accNr)); 
	}
	
	@Override
	public Optional<InvestmentDto> save(InvestmentDto investmentDao) {
		return Optional.ofNullable(investmentMapper.map(investmentRepository.save(investmentMapper.unmap(investmentDao))));
	}

	@Override
	public Optional<InvestmentDto> update(InvestmentDto investmentDao) {
		return Optional.ofNullable(investmentMapper.map(investmentRepository.save(investmentMapper.unmap(investmentDao))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		investmentRepository.delete(investmentMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("No investment with this id!"))));
	}

}
