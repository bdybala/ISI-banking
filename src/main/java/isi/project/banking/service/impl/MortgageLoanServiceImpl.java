package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.MortgageLoanDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.MortgageLoanMapper;
import isi.project.banking.repository.MortgageLoanRepository;
import isi.project.banking.service.MortgageLoanService;

@Service
@Primary
public class MortgageLoanServiceImpl implements MortgageLoanService {

	@Autowired
	MortgageLoanRepository mortgageLoanRepository;
	@Autowired
	MortgageLoanMapper mortgageLoanMapper;
	
	@Override
	public Optional<MortgageLoanDto> findOne(Integer id) {
		return Optional.ofNullable(mortgageLoanMapper.map(mortgageLoanRepository.findOne(id)));
	}

	@Override
	public List<MortgageLoanDto> findAll() {
		return mortgageLoanMapper.map(mortgageLoanRepository.findAll());
	}
	
	@Override
	public List<MortgageLoanDto> findByAccountAccNr(String accNr) {
		return mortgageLoanMapper.map(mortgageLoanRepository.findByAccountAccNr(accNr));
	}

	@Override
	public Optional<MortgageLoanDto> save(MortgageLoanDto mortgageLoanDto) {
		return Optional.ofNullable(mortgageLoanMapper.map(mortgageLoanRepository.save(mortgageLoanMapper.unmap(mortgageLoanDto))));
	}

	@Override
	public Optional<MortgageLoanDto> update(MortgageLoanDto mortgageLoanDto) {
		// TODO first findOne (orElseThrow) than save
		return Optional.ofNullable(mortgageLoanMapper.map(mortgageLoanRepository.save(mortgageLoanMapper.unmap(mortgageLoanDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		mortgageLoanRepository.delete(mortgageLoanMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("MortgageLoan with that id not in repo!"))));
	}

}
