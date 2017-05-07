package isi.project.banking;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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

import isi.project.banking.model.account.AccountService;
import isi.project.banking.model.client.Client;
import isi.project.banking.model.client.ClientService;
import net.sf.cglib.proxy.Factory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

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

		// hibernate
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();

		ClientService ser = new ClientService(em);
		List<Client> allClients = ser.findAllClients();
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

			return "client/user_account";
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		} finally {
			em.close();
			emf.close();
		}

	}
	//TODO
	@RequestMapping(value = "/invest", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		return "main-investments";
	}
	
	

}
