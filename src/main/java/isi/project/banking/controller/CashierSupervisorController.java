package isi.project.banking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cashiersupervisor")
public class CashierSupervisorController {
	private static final Logger logger = LoggerFactory.getLogger(CashierSupervisorController.class);
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public String cashierSupervisor(){
		logger.info("CashierSupervisor connecting!");
		
		return "cashierSupervisor/home";
	}
	
	//TODO
}
