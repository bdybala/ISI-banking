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

import isi.project.banking.model.client.Client;
import isi.project.banking.model.offerInvestment.OfferInvestmentService;
import isi.project.banking.model.offerLoan.OfferCashLoanService;
import isi.project.banking.model.offerLoan.OfferMortgageLoanService;

@Controller
public class OfferController {

	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

	@RequestMapping(value = "/offer-investments", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {

		Client client = (Client) session.getAttribute("client");
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


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		OfferInvestmentService ois = new OfferInvestmentService(em);
		// offer investments
		model.addAttribute("offerInvestments", ois.findAllOfferInvestments());


		return "offer-investments";

	}

	@RequestMapping(value = "/offer-investments-1", method = RequestMethod.GET)
	public String offer1(Locale locale, Model model, HttpSession session, 
			@ModelAttribute("offerInvestmentId") int offerInvestmentId){

		Client client = (Client) session.getAttribute("client");
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		OfferInvestmentService ois = new OfferInvestmentService(em);
		model.addAttribute("investmentOfferShown", ois.findOfferInvestment(offerInvestmentId));

		return "/offer-investments-1";
	}

	@RequestMapping(value = "/offer-loans", method = RequestMethod.GET)
	public String loans(Locale locale, Model model, HttpSession session) {

		Client client = (Client) session.getAttribute("client");
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();

		OfferMortgageLoanService omls = new OfferMortgageLoanService(em);
		OfferCashLoanService ocls = new OfferCashLoanService(em);
		model.addAttribute("offerMortgageLoans", omls.findAllOfferMortgageLoan());
		model.addAttribute("offerCashLoans", ocls.findAllOfferCashLoan());


		return "offer-loans";
	}


}
