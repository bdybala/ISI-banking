package isi.project.banking.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.dto.CashLoanDto;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.dto.MortgageLoanDto;
import isi.project.banking.model.Client;
import isi.project.banking.service.CashLoanService;
import isi.project.banking.service.MortgageLoanService;

@Controller
public class LoanController {

	@Autowired
	CashLoanService cashLoanService;
	@Autowired
	MortgageLoanService mortgageLoanService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@RequestMapping(value="/loans", method=RequestMethod.GET)
	public String loans(Locale locale, Model model, HttpSession session) {
		
		ClientDto clientDto = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l: {} checking his loans", clientDto.getLogin());
			List<CashLoanDto> cashLoansByAccount;
			List<MortgageLoanDto> mortgageLoansByAccount;
			
			for(AccountDto accountDto: clientDto.getAccounts()) {
				cashLoansByAccount = cashLoanService.findByAccountAccNr(accountDto.getAccNr());
				mortgageLoansByAccount = mortgageLoanService.findByAccountAccNr(accountDto.getAccNr());
				accountDto.setCashLoans(cashLoansByAccount);
				accountDto.setMortgageLoans(mortgageLoansByAccount);
			}
			
			model.addAttribute("loggedClient", clientDto);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}
		// last session access (in miliseconds)
		Date currentDate = new Date();
		if (currentDate.after(new Date(session.getLastAccessedTime())))
			model.addAttribute("lastAccessTimeInMs", currentDate.getTime());
		else
			model.addAttribute("lastAccessTimeInMs", session.getLastAccessedTime());
		// timeout period (in seconds)
		model.addAttribute("sessionTimeOutPeriodInMs", 1000 * session.getMaxInactiveInterval());
		
		
		return "client/loans";
	}
}
