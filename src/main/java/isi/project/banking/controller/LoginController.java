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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import isi.project.banking.HomeController;
import isi.project.banking.auth.SmsSender;
import isi.project.banking.dao.ClientDao;
import isi.project.banking.model.Client;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	ClientDao clientDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView client(Locale locale, Model model,
			HttpSession session) {
		logger.info("Welcome client! The client locale is {}.", locale);

		return new ModelAndView("login", "command", new Client());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute Client client,
			Locale locale, Model model,
			HttpSession session,
			RedirectAttributes redirectAttributes) {

		logger.info("logging in: l:{} p:{}", client.getLogin(), client.getPassword());

		client = clientDao.findByLoginAndPassword(client.getLogin(), client.getPassword());
		logger.info("logged in! #" + client.getPesel());

		session.setAttribute("client", client);

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
