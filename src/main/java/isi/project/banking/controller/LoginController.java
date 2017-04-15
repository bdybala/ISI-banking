package isi.project.banking.controller;

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
import org.springframework.web.servlet.ModelAndView;

import isi.project.banking.HomeController;
import isi.project.banking.model.client.Client;
import isi.project.banking.model.client.ClientService;

@Controller
public class LoginController {

private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView client(Locale locale, Model model,
			HttpSession session) {
		logger.info("Welcome client! The client locale is {}.", locale);
		
		return new ModelAndView("login", "command", new Client());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String addClient(@ModelAttribute Client client,
			Locale locale, Model model,
			HttpSession session) {
		
//		logger.info("logged in! #" + client.getLogin());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		ClientService clientService = new ClientService(em);
		
		client = clientService.findByLogin(client.getLogin());
		logger.info("logged in! #" + client.getPesel());
		
		session.setAttribute("client", client);
		
		return new HomeController().home(locale, model, session);
	}

}
