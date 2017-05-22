package isi.project.banking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cashier")
public class CashierController {
	private static final Logger logger = LoggerFactory.getLogger(CashierController.class);
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String cashier(){
		logger.info("Cashier connecting!");
		
		return "cashier/home";
	}
	//TODO

}
