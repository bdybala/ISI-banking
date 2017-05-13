package isi.project.banking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import isi.project.banking.HomeController;
import isi.project.banking.dao.AccountDao;
import isi.project.banking.dao.ClientDao;
import isi.project.banking.model.Account;
import isi.project.banking.model.Client;
import isi.project.banking.model.account.AccountService;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	AccountDao accountDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Locale locale, Model model) {
		logger.info("Welcome client! The client locale is {}.", locale);
		
		return new ModelAndView("form_register", "command", new Client());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Client client,
			Locale locale, Model model,
			HttpSession session){

		logger.info("register! " + client);
		
		clientDao.create(client);
		accountDao.create(new Account(client.getPesel(), "eKonto"));
		
		return new HomeController().home(locale, model, session);
	}
	//TODO
	@RequestMapping(value = "/change-password")
	public String passwordChange(HttpSession session, Locale locale, Model model){
		
		return "client/change-password";
	}
	//TODO
	@RequestMapping(value = "/user-settings")
	public String userSettings(HttpSession session, Locale locale, Model model){
		Client client = (Client) session.getAttribute("client");
		
		model.addAttribute("loggedClient", client);
		return "client/user-settings";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}