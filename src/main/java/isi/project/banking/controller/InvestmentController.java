package isi.project.banking.controller;

import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.HomeController;
import isi.project.banking.model.client.Client;
import isi.project.banking.model.investment.Investment;
import isi.project.banking.model.investment.InvestmentService;

@Controller
public class InvestmentController {

	private static final Logger logger = LoggerFactory.getLogger(InvestmentController.class);

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
		
		
		// TODO create Investment
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		InvestmentService is = new InvestmentService(em);
		
		investment.setOpenDate(new Date());
		Date closeDate = new Date((long) (investment.getOpenDate().getTime() + (long)investmentDuration*86400000));
		investment.setCloseDate(closeDate);
		is.createInvestment(investment);
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
