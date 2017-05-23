package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.WithdrawMapper;
import isi.project.banking.repository.WithdrawRepository;
import isi.project.banking.service.WithdrawService;

@Service
@Primary
public class WithdrawServiceImpl implements WithdrawService {

	@Autowired
	WithdrawRepository withdrawRepository;
	@Autowired
	WithdrawMapper withdrawMapper;
	
	@Override
	public Optional<WithdrawDto> findOne(Integer id) {
		return Optional.ofNullable(withdrawMapper.map(withdrawRepository.findOne(id)));
	}

	@Override
	public List<WithdrawDto> findAll() {
		return withdrawMapper.map(withdrawRepository.findAll());
	}

	@Override
	public List<WithdrawDto> findByAccountAccNr(String accNr) {
		return withdrawMapper.map(withdrawRepository.findByAccountAccNr(accNr));
	}
	
	@Override
	public Optional<WithdrawDto> save(WithdrawDto withdrawDto) {
		return Optional.ofNullable(withdrawMapper.map(withdrawMapper.unmap(withdrawDto)));
	}

	@Override
	public Optional<WithdrawDto> update(WithdrawDto withdrawDto) {
		// TODO findOne (orElseThrow) and than save
		return Optional.ofNullable(withdrawMapper.map(withdrawMapper.unmap(withdrawDto)));
	}

	@Override
	public void remove(Integer id) throws EntityNotFoundException {
		withdrawRepository.delete(withdrawMapper.unmap(findOne(id).orElseThrow(() 
				-> new EntityNotFoundException("Withdraw with that ID not in repo!"))));
	}

}
