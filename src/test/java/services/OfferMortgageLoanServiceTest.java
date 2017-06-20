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

import isi.project.banking.dto.OfferInvestmentDto;
import isi.project.banking.dto.OfferMortgageLoanDto;
import isi.project.banking.mappers.OfferMortgageLoanMapper;
import isi.project.banking.repository.OfferMortgageLoanRepository;
import isi.project.banking.service.OfferMortgageLoanService;
import isi.project.banking.service.impl.OfferMortgageLoanServiceImpl;

public class OfferMortgageLoanServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	OfferMortgageLoanRepository offerMortgageLoanRepository;
	
	@Mock
	OfferMortgageLoanMapper offerMortgageLoanMapper;
	
	@Mock
	OfferMortgageLoanDto omld;
	
	@Mock
	OfferMortgageLoanService omls;
	
	@InjectMocks
	OfferMortgageLoanServiceImpl omlsi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(omlsi).build();
	}
	
	@Test
	public void findOnetest()
	{
		Integer id=0;
		
		when(omls.findOne(id)).thenReturn(Optional.ofNullable( new OfferMortgageLoanDto() ));	
	}
	
	@Test
	public void findAllTest()
	{
		List<OfferMortgageLoanDto> list = new ArrayList<OfferMortgageLoanDto>();
		list.add(new OfferMortgageLoanDto());
		
		when(omlsi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest()
	{
		when(omls.save(omld)).thenReturn(Optional.ofNullable(new OfferMortgageLoanDto()));
		when(omls.update(omld)).thenReturn(Optional.ofNullable(new OfferMortgageLoanDto()));
	}
	

}
