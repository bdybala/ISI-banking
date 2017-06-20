package controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.CardController;
import isi.project.banking.model.Card;
import isi.project.banking.model.Client;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.repository.CardRepository;
import isi.project.banking.service.CardService;

public class CardControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	Client client;
	
	@Mock
	Card card;
	
	@Mock
	CardRepository cr;
	
	@Mock
	AccountRepository ap;
	
	@Mock
	HttpSession http;
	
	@Mock
	Model model;
	
	@Mock
	CardService cs;
	
	@Mock
	Session session;
	
	@Mock
	HttpSession httpSession;
	
	@Mock
	MockHttpSession mockhttp;
	
	@InjectMocks
	CardController cc;
	
	@Before
	public void setup()
	{
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cc).build();
	}
	
	
	@Test
	public void testInvestments()  throws Exception
	{
		
		model.addAttribute(card);
		model.addAttribute(mockhttp);
		mockMvc.perform(get("/card")).andExpect(status().isOk()).andExpect(view().name("index"));
		
		
	}

}
