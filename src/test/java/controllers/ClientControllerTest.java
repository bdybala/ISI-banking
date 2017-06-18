package controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.ClientController;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.mappers.ClientMapper;
import isi.project.banking.model.Client;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.ClientService;;

public class ClientControllerTest {
	
	private MockMvc mockMvc;
//	@Autowired
//	ClientRepository cp;
	
	@Mock
	ClientService cs;
	

	
	@Mock
	AccountRepository ap;
	
	@Mock
	HttpSession http;
	
	@Mock
	ClientRepository clientRepository;
	@Mock
	ClientMapper clientMapper;
	
	@Mock
	Model model;
	
	@InjectMocks
	ClientController cc;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cc).build();
		
		
		
	}
	
	
	@Test
	public void testGetRegister()  throws Exception
	{
		mockMvc.perform(get("/register")).andExpect(status().isOk());
		
	}
	
	@Test
	public void testPostRegister()  throws Exception
	{
		mockMvc.perform(post("/register")).andExpect(view().name("redirect:/"));
		
	}
	
	@Test
	public void testPasswordChange() throws Exception
	{
		mockMvc.perform(get("/change-password")).andExpect(view().name("client/change-password"));
		mockMvc.perform(post("/change-password")).andExpect(view().name("client/change-password"));
	}
	
	@Test
	public void testUserSettings() throws Exception
	{
		mockMvc.perform(get("/user-settings")).andExpect(view().name("client/user-settings"));
		mockMvc.perform(post("/user-settings")).andExpect(view().name("client/user-settings"));
	}
	



	
}
