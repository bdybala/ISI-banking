package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.InvestmentDto;

public interface InvestmentService extends BaseService<InvestmentDto, Integer> {

	List<InvestmentDto> findByAccountAccNr(String accNr);
}
