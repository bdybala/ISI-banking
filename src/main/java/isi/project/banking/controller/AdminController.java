package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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

import isi.project.banking.dto.ClientDto;
import isi.project.banking.exceptions.EntityNotFoundException;
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

		return "admin/home";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ModelAndView clients(Locale locale, Model model, HttpSession session) {

		logger.info("Admin checking clients list!");

		model.addAttribute("allClients", clientService.findAll());
		model.addAttribute("clientToDelete", new ClientDto());

		return new ModelAndView("admin/admin-clients");
	}

	@Transactional
	@RequestMapping(value="/delete-client", method = RequestMethod.POST)
	public String deleteClient(Locale locale, Model model, HttpSession session,
			@ModelAttribute ClientDto clientToDelete) {

		logger.info("Admin deletes client with pesel: " + clientToDelete.getPesel());
		try {
			accountService.removeByPesel(clientToDelete.getPesel());
			clientService.remove(clientToDelete.getPesel());
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/clients";
	}

	@RequestMapping(value="/clients/edit", method = RequestMethod.POST)
	public ModelAndView editClient(Locale locale, Model model, HttpSession session,
			@ModelAttribute ClientDto clientToEdit) {

		logger.info("Admin editing client: " + clientToEdit);

		clientToEdit = clientService.findOne(clientToEdit.getPesel()).orElse(null); 

		model.addAttribute("clientToEdit", clientToEdit);
		logger.info("clientToEdit: " + clientToEdit);
		return new ModelAndView("admin/edit-client");
	}

	@RequestMapping(value="/edit-client", method = RequestMethod.POST)
	public String updateClientEntity(Locale locale, Model model, HttpSession session,
			@ModelAttribute ClientDto clientToEdit) {

		logger.info("Admin edits client: " + clientToEdit);
		
		try {
			clientService.update(clientToEdit);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/clients";
	}

}
