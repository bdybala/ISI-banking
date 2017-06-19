package services;

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

import isi.project.banking.dto.CashLoanDto;
import isi.project.banking.mappers.CashLoanMapper;
import isi.project.banking.model.CashLoan;
import isi.project.banking.repository.CashLoanRepository;
import isi.project.banking.service.CashLoanService;
import isi.project.banking.service.impl.CashLoanServiceImpl;

public class CashLoanServiceTest {

	private MockMvc mockMvc;
	
	@Mock
	CashLoanRepository clr;
	
	@Mock
	CashLoanService cls;
	
	@Mock
	CashLoanMapper clm;
	
	@Mock
	CashLoanDto cashLoanDto;
	
	@InjectMocks
	CashLoanServiceImpl clsi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clsi).build();
	}
	
	@Test
	public void findOneTest()
	{
		
		Integer id=0;
		when(cls.findOne(id)).thenReturn(Optional.of(new CashLoanDto()));
	}
	
	@Test
	public void findAllTest()
	{
		List<CashLoanDto> cashLoans = new ArrayList<CashLoanDto>();
		when(clsi.findAll()).thenReturn(cashLoans);
	}
	
	@Test
	public void findByAccountNrTest()
	{
		String accNr="0000001";
		List<CashLoanDto> cashLoans = new ArrayList<CashLoanDto>();
		when(clsi.findByAccountAccNr(accNr)).thenReturn(cashLoans);
	}
	
	@Test
	public void saveTest()
	{
		// xD ??????
		when(clsi.save(cashLoanDto)).thenReturn(null);
	}
	
	
	
}
