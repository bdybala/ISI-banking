package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@RequestMapping(value = "/admin")
	public String admin(Locale locale, Model model, HttpSession session){
		
		return "/admin-panel";
	}

}
