package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.OfferMortgageLoanDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.OfferMortgageLoanMapper;
import isi.project.banking.repository.OfferMortgageLoanRepository;
import isi.project.banking.service.OfferMortgageLoanService;

@Service
@Primary
public class OfferMortgageLoanServiceImpl implements OfferMortgageLoanService {

	@Autowired
	OfferMortgageLoanRepository offerMortgageLoanRepository;
	@Autowired
	OfferMortgageLoanMapper offerMortgageLoanMapper;
	
	@Override
	public Optional<OfferMortgageLoanDto> findOne(Integer id) {
		return Optional.ofNullable(offerMortgageLoanMapper.map(offerMortgageLoanRepository.findOne(id)));
	}

	@Override
	public List<OfferMortgageLoanDto> findAll() {
		return offerMortgageLoanMapper.map(offerMortgageLoanRepository.findAll());
	}

	@Override
	public Optional<OfferMortgageLoanDto> save(OfferMortgageLoanDto offerMortgageLoanDto) {
		return Optional.ofNullable(offerMortgageLoanMapper.map(offerMortgageLoanRepository.save(offerMortgageLoanMapper.unmap(offerMortgageLoanDto))));
	}

	@Override
	public Optional<OfferMortgageLoanDto> update(OfferMortgageLoanDto offerMortgageLoanDto) {
		// TODO first findOne (orElseThrow) than save
		return Optional.ofNullable(offerMortgageLoanMapper.map(offerMortgageLoanRepository.save(offerMortgageLoanMapper.unmap(offerMortgageLoanDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		offerMortgageLoanRepository.delete(offerMortgageLoanMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("offerMortgageLoan with that ID not in repo!"))));
	}
	
}
