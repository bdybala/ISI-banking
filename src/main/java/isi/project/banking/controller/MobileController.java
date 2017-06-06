package isi.project.banking.controller;

import isi.project.banking.dto.MobilePaymentDto;
import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.exceptions.InvalidPinException;
import isi.project.banking.exceptions.NoRequiredFundsException;
import isi.project.banking.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public WithdrawDto executeWithdraw(@ModelAttribute("mobilePaymentDto") MobilePaymentDto mobilePaymentDto)
            throws EntityNotFoundException, NoRequiredFundsException, InvalidPinException {
    	System.out.println("MobilePaymentDto: " + mobilePaymentDto);
    	return withdrawService.executeMobilePayment(mobilePaymentDto);
    }
}
