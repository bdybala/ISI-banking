package isi.project.banking;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.dao.ClientDao;
import isi.project.banking.model.AbstractTransaction;
import isi.project.banking.model.Account;
import isi.project.banking.model.Client;
import isi.project.banking.model.account.AccountService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ClientDao clientDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		System.out.println("clientDao: " + clientDao);
		List<Client> allClients = clientDao.findAll();
		model.addAttribute("clients", allClients);

		Client client = (Client) session.getAttribute("client");
		try {

			logger.info("Logged account: {}", client.getPesel());
			model.addAttribute("loggedClient", client);

			// last session access (in miliseconds)
			Date currentDate = new Date();
			if (currentDate.after(new Date(session.getLastAccessedTime())))
				model.addAttribute("lastAccessTimeInMs", currentDate.getTime());
			else
				model.addAttribute("lastAccessTimeInMs", session.getLastAccessedTime());

			// timeout period (in seconds)
			model.addAttribute("sessionTimeOutPeriodInMs", 1000 * session.getMaxInactiveInterval());

			// transfer history
			List<List<AbstractTransaction>> transferHistory = new ArrayList<List<AbstractTransaction>>();
			for(Account account: client.getAccounts()) {
				transferHistory.add(AccountService.getTransactionsFromAccount(account));
			}
			model.addAttribute("transferHistory", transferHistory);
			
			return "client/user_account";
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}
	}
	
	
	//TODO
	@RequestMapping(value = "/invest", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		return "main-investments";
	}

}
