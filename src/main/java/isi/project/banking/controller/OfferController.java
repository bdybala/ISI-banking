package isi.project.banking.controller;

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
public class OfferController {

	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@RequestMapping(value = "/offer-investments", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		
		Client client = (Client) session.getAttribute("client");
		try {
			
			logger.info("User: {} checking investments offer", client.getLogin());
			model.addAttribute("loggedClient", client);
			return "offer-investments";
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}
		
	}

	@RequestMapping(value = "/offer-loans", method = RequestMethod.GET)
	public String loans(Locale locale, Model model, HttpSession session) {

		Client client = (Client) session.getAttribute("client");
		try {
			
			logger.info("User: {} checking loans offer", client.getLogin());
			model.addAttribute("loggedClient", client);
			return "offer-loans";
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}
	}
	
}
