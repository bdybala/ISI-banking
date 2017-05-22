package isi.project.banking.controller;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import isi.project.banking.HomeController;
import isi.project.banking.auth.SmsSender;
import isi.project.banking.dto.AccountDto;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.model.Client;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.AccountService;
import isi.project.banking.service.ClientService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	ClientService clientService;
	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView client(Locale locale, Model model,
			HttpSession session) {
		logger.info("Welcome client! The client locale is {}.", locale);

		return new ModelAndView("login", "command", new ClientDto());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute ClientDto clientDto,
			Locale locale, Model model,
			HttpSession session,
			RedirectAttributes redirectAttributes) throws EntityNotFoundException {

		final String login = clientDto.getLogin();
		final String password = clientDto.getPassword();
		
		logger.info("logging in: l:{} p:{}", login, password);
		
		clientDto = clientService.findByLoginAndPassword(login, password).orElseThrow(() 
				-> new EntityNotFoundException("Bad credentials! l: " + login + " p: " + password));
		logger.info("logged in! #" + clientDto.getPesel());

		List<AccountDto> accountsByPesel = accountService.findByPesel(clientDto.getPesel());
		clientDto.setAccounts(accountsByPesel);
		session.setAttribute("client", clientDto);

		// test
		//new SmsSender().sendSms("Yes!", "608595488");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {

		Client client = (Client) session.getAttribute("client");
		logger.info("logging out: l:{}", client.getLogin());

		session.removeAttribute("client");
		return new HomeController().home(locale, model, session);
	}

}
