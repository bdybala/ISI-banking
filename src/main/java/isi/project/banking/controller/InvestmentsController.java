package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InvestmentsController {

	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@RequestMapping(value = "/offer-investments-1", method = RequestMethod.GET)
	public String offer1(Locale locale, Model model, HttpSession session){
		
		return "/offer-investments-1";
	}
}
