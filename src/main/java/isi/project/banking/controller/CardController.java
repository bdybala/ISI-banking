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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.model.card.CardService;
import isi.project.banking.model.client.Client;

@Controller
public class CardController {

	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@RequestMapping(value = "/card", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		
		Client client = (Client) session.getAttribute("client");
		try {
			logger.info("User: {} checking cards", client.getLogin());
			model.addAttribute("loggedClient", client);
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		CardService ois = new CardService(em);
		// offer investments
		model.addAttribute("card", ois.findAllCard());
		
		// last session access (in miliseconds)
		Date currentDate = new Date();
		if (currentDate.after(new Date(session.getLastAccessedTime())))
			model.addAttribute("lastAccessTimeInMs", currentDate.getTime());
		else
			model.addAttribute("lastAccessTimeInMs", session.getLastAccessedTime());

		// timeout period (in seconds)
		model.addAttribute("sessionTimeOutPeriodInMs", 1000 * session.getMaxInactiveInterval());
		return "client/card";
		
	}

}