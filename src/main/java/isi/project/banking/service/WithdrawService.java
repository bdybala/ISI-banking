package isi.project.banking.service;

import java.util.List;

import isi.project.banking.dto.MobilePaymentDto;
import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.exceptions.InvalidPinException;
import isi.project.banking.exceptions.NoRequiredFundsException;

public interface WithdrawService extends BaseService<WithdrawDto, Integer> {

	public List<WithdrawDto> findByAccountAccNr(String accNr);

	WithdrawDto executeMobilePayment(MobilePaymentDto mobilePaymentDto) throws EntityNotFoundException, NoRequiredFundsException, InvalidPinException;

}
