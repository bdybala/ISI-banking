package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.CashLoanDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.CashLoanMapper;
import isi.project.banking.repository.CashLoanRepository;
import isi.project.banking.service.CashLoanService;

@Service
@Primary
public class CashLoanServiceImpl implements CashLoanService {

	@Autowired
	CashLoanRepository cashLoanRepository;
	@Autowired
	CashLoanMapper cashLoanMapper;
	
	@Override
	public Optional<CashLoanDto> findOne(Integer id) {
		return Optional.ofNullable(cashLoanMapper.map(cashLoanRepository.findOne(id)));
	}

	@Override
	public List<CashLoanDto> findAll() {
		return cashLoanMapper.map(cashLoanRepository.findAll());
	}
	
	@Override
	public List<CashLoanDto> findByAccountAccNr(String accNr) {
		return cashLoanMapper.map(cashLoanRepository.findByAccountAccNr(accNr));
	}

	@Override
	public Optional<CashLoanDto> save(CashLoanDto cashLoanDto) {
		return Optional.ofNullable(cashLoanMapper.map(cashLoanRepository.save(cashLoanMapper.unmap(cashLoanDto))));
	}

	@Override
	public Optional<CashLoanDto> update(CashLoanDto cashLoanDto) {
		// TODO first findOne in repo (orElseThrow) than save
		return Optional.ofNullable(cashLoanMapper.map(cashLoanRepository.save(cashLoanMapper.unmap(cashLoanDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		cashLoanRepository.delete(cashLoanMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("No such cashLoan in repo!"))));
	}

}
