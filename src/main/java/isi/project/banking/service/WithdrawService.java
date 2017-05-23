package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.WithdrawDto;

public interface WithdrawService extends BaseService<WithdrawDto, Integer> {

	public List<WithdrawDto> findByAccountAccNr(String accNr);
}
