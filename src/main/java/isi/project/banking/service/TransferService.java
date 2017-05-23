package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.TransferDto;

public interface TransferService extends BaseService<TransferDto, Integer> {

	public List<TransferDto> findBySenderAccNr(String accNr);
	public List<TransferDto> findByReceiverAccNr(String accNr);
}
