package isi.project.banking.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import isi.project.banking.HomeController;
import isi.project.banking.model.Client;
import isi.project.banking.model.Transfer;
import isi.project.banking.model.transfer.TransferService;

@Controller
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(@RequestParam String authenicationCode, Locale locale, Model model, HttpSession session){
		String code = (String) session.getAttribute("code");
		if(code.equals(authenicationCode))
		{
			Transfer transfer = (Transfer) session.getAttribute("transfer");
			
			transfer.setExecutionDate(new Date());
			transfer.setOrderDate(new Date());

			TransferService ts = new TransferService();
			Client client = (Client) session.getAttribute("client");
		
			ts.transfer(transfer, client.getPesel());
			
			return new HomeController().home(locale, model, session);
		}
		return "/authentication";
	}
	
}
