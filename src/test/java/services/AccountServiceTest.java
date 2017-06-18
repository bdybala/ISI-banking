package services;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.mappers.AccountMapper;
import isi.project.banking.model.account.AccountService;
import isi.project.banking.repository.AccountRepository;
import isi.project.banking.service.impl.AccountServiceImpl;

public class AccountServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	AccountMapper accountMapper;
	
	@Mock
	AccountDto accountDto;
	
	@Mock
	AccountService as;
	
	@InjectMocks
	AccountServiceImpl asi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(as).build();
	}
	
//	@Test
//	public void findOneTest() throws Exception
//	{
//		String accNr = "1";
//		
//		when(asi.findOne(accNr)).thenReturn(Optional.ofNullable(new AccountDto())); 
//	}
	
	@Test
	public void findByPesel()
	{
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		String pesel="00000000000";
		when(asi.findByPesel(pesel)).thenReturn(accounts);
	}
	
	@Test
	public void findaAllTest()
	{
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		accounts.add(new AccountDto());
		
		when(asi.findAll()).thenReturn(accounts);
	}
	
//	@Test
//	public void saveAndUpdateTest()
//	{
//		doReturn(accountDto).when(asi.findAll());
//	}
	
	
	

}
