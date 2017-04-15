package isi.project.banking;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// hibernate test
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		
		ClientService ser = new ClientService(em);
//		Client client = ser.createClient(
//				"95010112345","login","password","Jan","Kowalski",
//				"jkowal@gmail.com","22 444 44 44", new Date());
		List<Client> allClients = ser.findAllClients();
		
		System.out.println(allClients.size());
		model.addAttribute("clients", allClients);
		em.close();
		emf.close();
		return "home";
	}
	
}
