package isi.project.banking.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.model.client.Client;
import isi.project.banking.model.transfer.Transfer;
import isi.project.banking.model.transfer.TransferService;


@Controller
public class TransferController {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

	@RequestMapping(value = "/user_account_transfer", method = RequestMethod.GET)
	public String regularTransfer(Locale locale, Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("client");

		try {

			logger.info("User: {} transfering cash", client.getLogin());
			model.addAttribute("loggedClient", client);

			// last session access (in miliseconds)
			Date currentDate = new Date();
			if (currentDate.after(new Date(session.getLastAccessedTime())))
				model.addAttribute("lastAccessTimeInMs", currentDate.getTime());
			else
				model.addAttribute("lastAccessTimeInMs", session.getLastAccessedTime());

			// timeout period (in seconds)
			model.addAttribute("sessionTimeOutPeriodInMs", 1000 * session.getMaxInactiveInterval());

			return "client/user_account_transfer";

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}

	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String doTransfer(@ModelAttribute("transfer") Transfer transfer, Locale locale, Model model,
			HttpSession session) {

		transfer.setExecutionDate(new Date());
		transfer.setOrderDate(new Date());

		TransferService ts = new TransferService();
		Client client = (Client) session.getAttribute("client");
		
		ts.transfer(transfer, client.getPesel());
		return "authentication";

	}
		
}
