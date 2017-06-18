package controllers;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.InvestmentController;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.dto.InvestmentDto;
import isi.project.banking.service.InvestmentService;

public class InvestmentControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	InvestmentService is;
	
	@Mock
	ClientDto client;
	
	@Mock
	Model model;
	
	@Mock
	HttpSession httpSession;
	
	@Mock
	InvestmentDto investmentDto;

	
	

	
	@InjectMocks
	InvestmentController ic;
	
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		//model.addAttribute("loggedClient", client);
		mockMvc = MockMvcBuilders.standaloneSetup(ic).build();
	}
	
	@Test
	public void putUpInvestmentTest() throws Exception
	{
		mockMvc.perform(get("/investments")).andExpect(status().isOk());
		//Mockito.verify(ic,times(1)).putUpInvestment(locale, model, session, investmentDto, offerInvestmentId, investmentDuration)
		Mockito.verify(is,times(1)).save(investmentDto);
	}

}
