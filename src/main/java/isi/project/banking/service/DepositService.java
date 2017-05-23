package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.DepositDto;

public interface DepositService extends BaseService<DepositDto, Integer> {

	public List<DepositDto> findByAccountAccNr(String accNr);
}
