package controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.AuthenticationController;
import isi.project.banking.controller.OfferController;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.mappers.ClientMapper;
import isi.project.banking.model.Client;
import isi.project.banking.model.Transfer;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.ClientService;
import isi.project.banking.service.TransferService;
import isi.project.banking.service.impl.ClientServiceImpl;

public class AuthenticationControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	ClientDto cdt;
	
	@Mock
	ClientRepository cr;
	
	@Mock
	Model model;
	

	
	@Mock
	OfferController offerController;
	
	
	@Mock
	HttpSession httpSession;
	
	@Mock
	Transfer transfer;
	
	@Mock
	TransferService ts;
	
	@Mock
	Client client;
	
	@InjectMocks
	AuthenticationController ac;

	
	
	

	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
	}
	
	
//	@Test
//	public void test() throws Exception
//	{
//		mockMvc.perform(post("/auth")).andExpect(view().name("/authentication"));
//	}
}
