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

import isi.project.banking.dto.OfferMortgageLoanDto;
import isi.project.banking.dto.TransferDto;
import isi.project.banking.mappers.TransferMapper;
import isi.project.banking.repository.TransferRepository;
import isi.project.banking.service.TransferService;
import isi.project.banking.service.impl.TransferServiceImpl;

public class TransferServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	TransferRepository transferRepository;

	@Mock
	TransferMapper transferMapper;
	
	@Mock
	TransferDto transferDto;
	
	@Mock
	TransferService ts;
	
	@InjectMocks
	TransferServiceImpl tsi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(tsi).build();
	}
	
	@Test
	public void findOnetest()
	{
		Integer id=0;
		
		when(ts.findOne(id)).thenReturn(Optional.ofNullable( new TransferDto() ));	
	}
	
	@Test
	public void findAllTest()
	{
		List<TransferDto> list = new ArrayList<TransferDto>();
		list.add(new TransferDto());
		
		when(tsi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest()
	{
		when(ts.save(transferDto)).thenReturn(Optional.ofNullable(new TransferDto()));
		when(ts.update(transferDto)).thenReturn(Optional.ofNullable(new TransferDto()));
	}
	
	
	
}
