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
import org.springframework.web.bind.annotation.RequestParam;

import isi.project.banking.model.client.Client;
import isi.project.banking.model.client.ClientService;

@Controller
@RequestMapping(value = "/admin")
class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//TODO
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String admin(Locale locale, Model model, HttpSession session){
		
		logger.info("Admin connecting!");
		
		return "admin/admin-home";
	}
	
	@RequestMapping(value="/delete-client", method=RequestMethod.GET)
	public String deleteClient(Locale locale, Model model, HttpSession session) {
		
		logger.info("Admin intends to delete client!");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
		EntityManager em = emf.createEntityManager();
		
		ClientService clientService = new ClientService(em);
		model.addAttribute("allClients", clientService.findAllClients());
		model.addAttribute("cl", new Client());
		
		return "admin/delete-client";
	}
	
	@RequestMapping(value="/delete-client", method=RequestMethod.POST)
	public String deleteClient(Locale locale, Model model, HttpSession session,
			@ModelAttribute("cl") Client client,
			@RequestParam("pesel") String pesel) {
		
		// TODO deleting client
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate.isi");
//		EntityManager em = emf.createEntityManager();
//		
//		ClientService clientService = new ClientService(em);
//		TODO clientService.deleteClient();
//		
		
		System.out.println("client: " + client.getPesel());
		System.out.println("Pesel: " + pesel);
		return new AdminController().deleteClient(locale, model, session);
	}

}
