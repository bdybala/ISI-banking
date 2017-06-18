package services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import isi.project.banking.controller.ClientController;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.mappers.ClientMapper;
import isi.project.banking.model.Client;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.ClientService;
import isi.project.banking.service.impl.ClientServiceImpl;

public class ClientServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	ClientDto cdt;
	
	@Mock
	ClientRepository cr;
	
	@Mock
	ClientMapper cm;
	
	
	@Mock
	ClientService cs;
	
	
	@InjectMocks
	ClientServiceImpl csi;
//	@InjectMocks
//	ClientController cc;
	
	
	

	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cs).build();
		
		
		
	}
	
	@Test
	public void testListAll() throws Exception
	{
		boolean test=false;
		List<ClientDto> clients=new ArrayList<>();
		clients.add(new ClientDto());
		clients.add(new ClientDto());
	
		when(cs.findAll()).thenReturn((List) clients);
		clients=cs.findAll();
//		when(clients.size()).thenReturn(2);
//		when(verify(csi,times(0)).findAll()).thenReturn(null);
		
	}
	
	@Test
	public void findOneTest() throws Exception
	{

	
		String test="00000000000";
		
		when(cs.findOne(test)).thenReturn(Optional.ofNullable( new ClientDto() ));
	}
	
	@Test
	public void findByLoginAndPasswordTest() throws Exception
	{
		String login="test";
		String password="test123";
		
		when(cs.findByLoginAndPassword(login, password)).thenReturn(Optional.ofNullable(new ClientDto()));
	}
	
	
	@Test
	public void saveAndUpdateTest() throws Exception
	{
		when(cs.save(cdt)).thenReturn(Optional.ofNullable(new ClientDto()));
		when(cs.update(cdt)).thenReturn(Optional.ofNullable(new ClientDto()));
	}
}
