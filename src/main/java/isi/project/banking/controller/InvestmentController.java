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

import isi.project.banking.HomeController;
import isi.project.banking.dao.InvestmentDao;
import isi.project.banking.model.client.Client;
import isi.project.banking.model.investment.Investment;

@Controller
public class InvestmentController {

	private static final Logger logger = LoggerFactory.getLogger(InvestmentController.class);

	@Autowired
	InvestmentDao investmentDao;
	
	@RequestMapping(value="/put-up-investment", method=RequestMethod.POST)
	public String putUpInvestment(Locale locale, Model model, HttpSession session, 
			@ModelAttribute("investment-form") Investment investment,
			@ModelAttribute("offerInvestmentId") int offerInvestmentId,
			@ModelAttribute("investmentDuration") int investmentDuration) {

		Client client = (Client) session.getAttribute("client");
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
		
		
		investment.setOpenDate(new Date());
		Date closeDate = new Date((long) (investment.getOpenDate().getTime() + (long)investmentDuration*86400000));
		investment.setCloseDate(closeDate);
		investmentDao.create(investment);;
		System.out.println(
				"ID: " + investment.getId() + "\n" +
				"Name: " + investment.getName() + "\n" +
				"accNr: " + investment.getAccNr() + "\n" +
				"openDate: " + investment.getOpenDate() + "\n" +
				"closeDate: " + investment.getCloseDate() + "\n" +
				"interest: " + investment.getInterest() + "\n" +
				"balance: " + investment.getBalance()
				);
		
		return new HomeController().home(locale, model, session);
	}
	
	@RequestMapping(value="/investments", method=RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		
		Client client = (Client) session.getAttribute("client");
		try {
			logger.info("l: {} checking his investments", client.getLogin());
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
		
		
		return "client/investments";
	}
}
