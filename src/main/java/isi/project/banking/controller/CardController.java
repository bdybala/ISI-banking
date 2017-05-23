package isi.project.banking.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.model.Client;
import isi.project.banking.repository.CardRepository;

@Controller
public class CardController {

	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	CardRepository cardRepository;
	
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

		
		model.addAttribute("card", cardRepository.findAll());
		
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