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

import isi.project.banking.dto.InvestmentDto;
import isi.project.banking.mappers.InvestmentMapper;
import isi.project.banking.repository.InvestmentRepository;
import isi.project.banking.service.InvestmentService;
import isi.project.banking.service.impl.InvestmentServiceImpl;

public class InvestmentServiceTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	InvestmentRepository investmentRepository;

	@Mock
	InvestmentMapper investmentMapper;
	
	@Mock
	InvestmentService is;
	
	@Mock
	InvestmentDto idt;
	
	
	@InjectMocks
	InvestmentServiceImpl isi;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(is).build();
	}
	
	@Test
	public void findOneTest()
	{
		Integer nr=0;
		
		when(is.findOne(nr)).thenReturn(Optional.ofNullable(new InvestmentDto()));
		
	}
	
	@Test
	public void findAllTest()
	{
		List<InvestmentDto> list= new ArrayList<InvestmentDto>();
		list.add(new InvestmentDto());
		Integer id=0;
		
		when(is.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdate()
	{
		when(is.save(idt)).thenReturn(Optional.ofNullable(new InvestmentDto()));
		when(is.update(idt)).thenReturn(Optional.ofNullable(new InvestmentDto()));
		
	}
	
}
