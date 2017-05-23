package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.OfferCashLoanDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.OfferCashLoanMapper;
import isi.project.banking.repository.OfferCashLoanRepository;
import isi.project.banking.service.OfferCashLoanService;

@Service
@Primary
public class OfferCashLoanServiceImpl implements OfferCashLoanService {

	@Autowired
	OfferCashLoanRepository offerCashLoanRepository;
	@Autowired
	OfferCashLoanMapper offerCashLoanMapper;
	
	@Override
	public Optional<OfferCashLoanDto> findOne(Integer id) {
		return Optional.ofNullable(offerCashLoanMapper.map(offerCashLoanRepository.findOne(id)));
	}

	@Override
	public List<OfferCashLoanDto> findAll() {
		return offerCashLoanMapper.map(offerCashLoanRepository.findAll());
	}

	@Override
	public Optional<OfferCashLoanDto> save(OfferCashLoanDto offerCashLoanDto) {
		return Optional.ofNullable(offerCashLoanMapper.map(offerCashLoanRepository.save(offerCashLoanMapper.unmap(offerCashLoanDto))));
	}

	@Override
	public Optional<OfferCashLoanDto> update(OfferCashLoanDto offerCashLoanDto) {
		// TODO first findOne (orElseThrow) than save
		return Optional.ofNullable(offerCashLoanMapper.map(offerCashLoanRepository.save(offerCashLoanMapper.unmap(offerCashLoanDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		offerCashLoanRepository.delete(offerCashLoanMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("OfferCashLoan with that ID not in repo!"))));
	}

}
