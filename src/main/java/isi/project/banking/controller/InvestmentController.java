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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.HomeController;
import isi.project.banking.dto.AccountDto;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.dto.InvestmentDto;
import isi.project.banking.service.InvestmentService;

@Controller
public class InvestmentController {

	private static final Logger logger = LoggerFactory.getLogger(InvestmentController.class);

	@Autowired
	InvestmentService investmentService;
	
	@RequestMapping(value="/put-up-investment", method=RequestMethod.POST)
	public String putUpInvestment(Locale locale, Model model, HttpSession session, 
			@ModelAttribute("investment-form") InvestmentDto investmentDto,
			@ModelAttribute("offerInvestmentId") int offerInvestmentId,
			@ModelAttribute("investmentDuration") int investmentDuration) {

		ClientDto client = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l: {} putting up an investment #{}", client.getLogin(), offerInvestmentId);
			model.addAttribute("loggedClient", client);
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
		
		investmentDto.setOpenDate(new Date());
		Date closeDate = new Date((long) (investmentDto.getOpenDate().getTime() + (long)investmentDuration*86400000));
		investmentDto.setCloseDate(closeDate);
		investmentService.save(investmentDto);
		System.out.println(
				"ID: " + investmentDto.getId() + "\n" +
				"Name: " + investmentDto.getName() + "\n" +
				"accNr: " + investmentDto.getAccNr() + "\n" +
				"openDate: " + investmentDto.getOpenDate() + "\n" +
				"closeDate: " + investmentDto.getCloseDate() + "\n" +
				"interest: " + investmentDto.getInterest() + "\n" +
				"balance: " + investmentDto.getBalance()
				);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/investments", method=RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		
		ClientDto clientDto = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l: {} checking his investments", clientDto.getLogin());
			List<InvestmentDto> investmentsByAccount;
			
			for(AccountDto accountDto: clientDto.getAccounts()) {
				investmentsByAccount = investmentService.findByAccountAccNr(accountDto.getAccNr());
				accountDto.setInvestments(investmentsByAccount);
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
		
		
		return "client/investments";
	}
}
