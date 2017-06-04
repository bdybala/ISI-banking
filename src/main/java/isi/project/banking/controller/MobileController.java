package isi.project.banking.controller;

import isi.project.banking.dto.MobilePaymentDto;
import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.exceptions.InvalidPinException;
import isi.project.banking.exceptions.NoRequiredFundsException;
import isi.project.banking.service.WithdrawService;
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
