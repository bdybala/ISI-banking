package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.CashLoanDto;

public interface CashLoanService extends BaseService<CashLoanDto, Integer> {

	List<CashLoanDto> findByAccountAccNr(String accNr);
}
