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

import isi.project.banking.auth.AuthSMS;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.model.Client;
import isi.project.banking.model.Transfer;


@Controller
public class TransferController {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

	@RequestMapping(value = "/user_account_transfer", method = RequestMethod.GET)
	public String regularTransfer(Locale locale, Model model, HttpSession session) {
		ClientDto clientDto = (ClientDto) session.getAttribute("client");

		try {

			logger.info("User: {} transfering cash", clientDto.getLogin());
			model.addAttribute("loggedClient", clientDto);

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
	public String confirmTransfer(@ModelAttribute("transfer") Transfer transfer, Locale locale, Model model,
			HttpSession session) {

		Client client = (Client) session.getAttribute("client");
		String code = new AuthSMS().sendCode();
		session.setAttribute("transfer", transfer);
		session.setAttribute("code", code);
		System.out.println(code);
		return "authentication";

	}
	
	/*@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String doTransfer(Locale locale, Model model, HttpSession session) {
		
		Transfer transfer = (Transfer) session.getAttribute("transfer");
		
		transfer.setExecutionDate(new Date());
		transfer.setOrderDate(new Date());

		TransferService ts = new TransferService();
		Client client = (Client) session.getAttribute("client");
	
		ts.transfer(transfer, client.getPesel());
		
		return "home";

	}*/
		
}
