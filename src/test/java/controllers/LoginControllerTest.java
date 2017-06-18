package controllers;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.LoginController;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.service.InvestmentService;

public class LoginControllerTest {
	
private MockMvc mockMvc;
	
	@Mock
	InvestmentService is;
	
	@Mock
	ClientDto client;
	
	@Mock
	Model model;
	
	@Mock
	HttpSession httpSession;
	
	@InjectMocks
	LoginController lc;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(lc).build();
	}
	
	@Test
	public void tes1()
	{
		//
	}

}
