package services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import isi.project.banking.dto.AccountDto;
import isi.project.banking.dto.DepositDto;
import isi.project.banking.mappers.DepositMapper;
import isi.project.banking.repository.DepositRepository;
import isi.project.banking.service.DepositService;
import isi.project.banking.service.impl.DepositServiceImpl;

public class DepositServiceTest {

	MockMvc mockMvc;
	
	@Mock
	DepositRepository dp;

	@Mock
	DepositMapper dm;
	
	@Mock
	DepositService ds;
	
	@Mock
	DepositDto dd;
	
	
	@InjectMocks
	DepositServiceImpl dsi;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(dsi).build();
	}
	
	@Test
	public void findByAccountAccNrTest()
	{
		List<DepositDto> deposits = new ArrayList<DepositDto>();
		String accNr="00000000000";
		when(dsi.findByAccountAccNr(accNr)).thenReturn(deposits);
	}
	
	@Test
	public void findaAllTest()
	{
		List<DepositDto> deposits = new ArrayList<DepositDto>();
		deposits.add(new DepositDto());
		
		when(dsi.findAll()).thenReturn(deposits);
	}
	
	
}
