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

import isi.project.banking.dto.ClientDto;
import isi.project.banking.dto.DepositDto;
import isi.project.banking.dto.OfferCashLoanDto;
import isi.project.banking.mappers.OfferCashLoanMapper;
import isi.project.banking.repository.OfferCashLoanRepository;
import isi.project.banking.service.OfferCashLoanService;
import isi.project.banking.service.impl.OfferCashLoanServiceImpl;

public class OfferCashLoanServiceTest {
	
	
	private MockMvc mockMvc;

	
	@Mock
	OfferCashLoanRepository offerCashLoanRepository;
	
	@Mock
	OfferCashLoanMapper offerCashLoanMapper;
	
	@Mock
	OfferCashLoanDto ocld;
	
	@Mock
	OfferCashLoanService ocls;
	
	@InjectMocks
	OfferCashLoanServiceImpl oclsi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(oclsi).build();
	}

	@Test
	public void findOnetest()
	{
		Integer id=0;
		
		when(ocls.findOne(id)).thenReturn(Optional.ofNullable( new OfferCashLoanDto() ));	
	}
	
	
	@Test
	public void findAllTest()
	{
		List<OfferCashLoanDto> list = new ArrayList<OfferCashLoanDto>();
		list.add(new OfferCashLoanDto());
		
		when(oclsi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest()
	{
		when(ocls.save(ocld)).thenReturn(Optional.ofNullable(new OfferCashLoanDto()));
		when(ocls.update(ocld)).thenReturn(Optional.ofNullable(new OfferCashLoanDto()));
	}
	
}
