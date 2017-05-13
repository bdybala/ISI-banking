package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import isi.project.banking.dao.ClientDao;
import isi.project.banking.model.Client;

@Controller
@RequestMapping(value = "/admin")
class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ClientDao clientDao;
	
	//TODO
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String admin(Locale locale, Model model, HttpSession session){
		
		logger.info("Admin connecting!");
		
		return "admin/admin-home";
	}
	
	@RequestMapping(value="/delete-client", method=RequestMethod.GET)
	public String deleteClient(Locale locale, Model model, HttpSession session) {
		
		logger.info("Admin intends to delete client!");
		
		model.addAttribute("allClients", clientDao.findAll());
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
