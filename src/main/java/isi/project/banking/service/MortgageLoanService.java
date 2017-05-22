package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.MortgageLoanDto;

public interface MortgageLoanService extends BaseService<MortgageLoanDto, Integer> {

	List<MortgageLoanDto> findByAccountAccNr(String accNr);
}
