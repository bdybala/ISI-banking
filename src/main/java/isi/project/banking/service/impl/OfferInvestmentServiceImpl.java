package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.OfferInvestmentDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.OfferInvestmentMapper;
import isi.project.banking.repository.OfferInvestmentRepository;
import isi.project.banking.service.OfferInvestmentService;

@Service
@Primary
public class OfferInvestmentServiceImpl implements OfferInvestmentService {

	@Autowired
	OfferInvestmentRepository offerInvestmentRepository;
	@Autowired
	OfferInvestmentMapper offerInvestmentMapper;
	
	
	@Override
	public Optional<OfferInvestmentDto> findOne(Integer id) {
		return Optional.ofNullable(offerInvestmentMapper.map(offerInvestmentRepository.findOne(id)));
	}

	@Override
	public List<OfferInvestmentDto> findAll() {
		return offerInvestmentMapper.map(offerInvestmentRepository.findAll());
	}

	@Override
	public Optional<OfferInvestmentDto> save(OfferInvestmentDto offerInvestmentDto) {
		return Optional.ofNullable(offerInvestmentMapper.map(offerInvestmentRepository.save(offerInvestmentMapper.unmap(offerInvestmentDto))));
	}

	@Override
	public Optional<OfferInvestmentDto> update(OfferInvestmentDto offerInvestmentDto) {
		// TODO first findOne (orElseThrow) than save
		return Optional.ofNullable(offerInvestmentMapper.map(offerInvestmentRepository.save(offerInvestmentMapper.unmap(offerInvestmentDto))));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		offerInvestmentRepository.delete(offerInvestmentMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("OfferInvestment with that ID not in repo!"))));
	}

}
