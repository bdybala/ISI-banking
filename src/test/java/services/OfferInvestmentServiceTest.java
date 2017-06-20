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

import isi.project.banking.dto.OfferCashLoanDto;
import isi.project.banking.dto.OfferInvestmentDto;
import isi.project.banking.mappers.OfferInvestmentMapper;
import isi.project.banking.repository.OfferInvestmentRepository;
import isi.project.banking.service.OfferInvestmentService;
import isi.project.banking.service.impl.OfferInvestmentServiceImpl;

public class OfferInvestmentServiceTest {
	
	private MockMvc mockMvc;

	@Mock
	OfferInvestmentRepository offerInvestmentRepository;
	
	@Mock
	OfferInvestmentMapper offerInvestmentMapper;
	
	@Mock
	OfferInvestmentDto ofid;
	
	@Mock
	OfferInvestmentService ois;
	
	@InjectMocks
	OfferInvestmentServiceImpl oisi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(oisi).build();
	}
	
	@Test
	public void findOnetest()
	{
		Integer id=0;
		
		when(ois.findOne(id)).thenReturn(Optional.ofNullable( new OfferInvestmentDto() ));	
	}
	
	@Test
	public void findAllTest()
	{
		List<OfferInvestmentDto> list = new ArrayList<OfferInvestmentDto>();
		list.add(new OfferInvestmentDto());
		
		when(oisi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest()
	{
		when(ois.save(ofid)).thenReturn(Optional.ofNullable(new OfferInvestmentDto()));
		when(ois.update(ofid)).thenReturn(Optional.ofNullable(new OfferInvestmentDto()));
	}
	
}
