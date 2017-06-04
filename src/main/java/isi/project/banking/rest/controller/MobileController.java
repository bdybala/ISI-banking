package isi.project.banking.rest.controller;

import isi.project.banking.rest.dto.MobilePaymentDto;
import isi.project.banking.rest.dto.WithdrawDto;
import isi.project.banking.rest.exception.EntityNotFoundException;
import isi.project.banking.rest.exception.InvalidPinException;
import isi.project.banking.rest.exception.NoRequiredFundsException;
import isi.project.banking.rest.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MobileController {

    @Autowired
    private WithdrawService withdrawService;

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public WithdrawDto executeWithdraw(@RequestBody MobilePaymentDto mobilePaymentDto)
            throws EntityNotFoundException, NoRequiredFundsException, InvalidPinException {
        return withdrawService.executeMobilePayment(mobilePaymentDto);
    }
}
