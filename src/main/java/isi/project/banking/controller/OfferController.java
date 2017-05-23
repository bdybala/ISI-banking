package isi.project.banking.controller;

import java.util.Date;
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

import isi.project.banking.dto.ClientDto;
import isi.project.banking.model.Client;
import isi.project.banking.repository.OfferCashLoanRepository;
import isi.project.banking.repository.OfferInvestmentRepository;
import isi.project.banking.repository.OfferMortgageLoanRepository;
import isi.project.banking.service.OfferCashLoanService;
import isi.project.banking.service.OfferInvestmentService;
import isi.project.banking.service.OfferMortgageLoanService;

@Controller
public class OfferController {

	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@Autowired
	OfferInvestmentService offerInvestmentService;
	@Autowired
	OfferCashLoanService offerCashLoanService;
	@Autowired
	OfferMortgageLoanService offerMortgageLoanService;
	
	@RequestMapping(value = "/offer-investments", method = RequestMethod.GET)
	public String investments( Model model, HttpSession session) {

		ClientDto client = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l:{} checking investments offer", client.getLogin());
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


		// offer investments
		model.addAttribute("offerInvestments", offerInvestmentService.findAll());

		return "client/offer-investments";

	}

	@RequestMapping(value = "/offer-investments-1", method = RequestMethod.GET)
	public String offer1(Locale locale, Model model, HttpSession session, 
			@ModelAttribute("offerInvestmentId") int offerInvestmentId){

		ClientDto client = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l:{} checking #{} investment offer", client.getLogin(), offerInvestmentId);
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


		// specific investment offer
		model.addAttribute("investmentOfferShown", offerInvestmentService.findOne(offerInvestmentId));

		return "client/offer-investments-1";
	}

	@RequestMapping(value = "/offer-loans", method = RequestMethod.GET)
	public String loans(Locale locale, Model model, HttpSession session) {

		ClientDto client = (ClientDto) session.getAttribute("client");
		try {
			logger.info("l:{} checking loans offer", client.getLogin());
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

		// loans offer
		model.addAttribute("offerMortgageLoans", offerMortgageLoanService.findAll());
		model.addAttribute("offerCashLoans", offerCashLoanService.findAll());


		return "client/offer-loans";
	}
	
	@RequestMapping(value="/offer-mortgage", method = RequestMethod.GET)
	public String offerMortgage(Locale locale, Model model, HttpSession session){
		ClientDto client = (ClientDto) session.getAttribute("client");
		model.addAttribute("loggedClient", client);
		//TODO
		return "client/offer-mortgage";
	}


}
