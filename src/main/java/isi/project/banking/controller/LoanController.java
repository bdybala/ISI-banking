package isi.project.banking.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.model.client.Client;

@Controller
public class LoanController {

	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@RequestMapping(value="/loans", method=RequestMethod.GET)
	public String loans(Locale locale, Model model, HttpSession session) {
		
		Client client = (Client) session.getAttribute("client");
		try {
			logger.info("l: {} checking his loans", client.getLogin());
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
		
		
		return "client/loans";
	}
}
