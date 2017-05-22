package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Client;
import isi.project.banking.service.AccountService;
import isi.project.banking.service.ClientService;

@Controller
@RequestMapping(value = "/admin")
class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	@Qualifier("ClientService")
	ClientService clientService;
	@Autowired
	@Qualifier("AccountService")
	AccountService accountService;
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String admin(Locale locale, Model model, HttpSession session){
		
		logger.info("Admin connecting!");
		
		return "admin/admin-home";
	}
	
	@RequestMapping(value = "/clients")
	public ModelAndView clients(Locale locale, Model model, HttpSession session) {
		
		logger.info("Admin checking clients list!");
		
		model.addAttribute("allClients", clientService.findAll());
		model.addAttribute("clientToDelete", new Client());
		
		return new ModelAndView("admin/admin-clients");
	}
	 
	@RequestMapping(value="/delete-client")
	public String deleteClient(Locale locale, Model model, HttpSession session,
			@ModelAttribute Client clientToDelete) {
		
		logger.info("Admin deletes client with pesel: " + clientToDelete.getPesel());
		System.out.println("WYJEB: client: " + clientToDelete.getPesel());
		try {
			accountService.removeByPesel(clientToDelete.getPesel());
			clientService.remove(clientToDelete.getPesel());
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/clients";
	}
	
}
