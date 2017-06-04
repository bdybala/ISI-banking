package isi.project.banking.rest.service;

import isi.project.banking.rest.dto.MobilePaymentDto;
import isi.project.banking.rest.dto.WithdrawDto;
import isi.project.banking.rest.exception.EntityNotFoundException;
import isi.project.banking.rest.exception.InvalidPinException;
import isi.project.banking.rest.exception.NoRequiredFundsException;

public interface WithdrawService {

    WithdrawDto executeMobilePayment(MobilePaymentDto mobilePaymentDto) throws EntityNotFoundException, InvalidPinException, NoRequiredFundsException;

}
