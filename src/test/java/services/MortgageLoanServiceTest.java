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
import isi.project.banking.dto.MortgageLoanDto;
import isi.project.banking.mappers.MortgageLoanMapper;
import isi.project.banking.model.MortgageLoan;
import isi.project.banking.repository.MortgageLoanRepository;
import isi.project.banking.service.MortgageLoanService;
import isi.project.banking.service.impl.MortgageLoanServiceImpl;

public class MortgageLoanServiceTest {
	
	MockMvc mockMvc;
	
	@Mock
	MortgageLoanRepository mortgageLoanRepository;

	@Mock
	MortgageLoanMapper mortgageLoanMapper;
	
	@Mock
	MortgageLoanDto mortgageLoanDto;
	
	@Mock
	MortgageLoanService mls;
	
	@InjectMocks
	MortgageLoanServiceImpl mlsi;
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mlsi).build();
	}
	
	@Test
	public void findOneTest()
	{
		Integer id=0;
		
		when(mls.findOne(id)).thenReturn(Optional.ofNullable( new MortgageLoanDto() ));
	}
	
	@Test
	public void findaAllTest()
	{
		List<MortgageLoanDto> list = new ArrayList<MortgageLoanDto>();
		list.add(new MortgageLoanDto());
		
		when(mlsi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest() throws Exception
	{
		when(mls.save(mortgageLoanDto)).thenReturn(Optional.ofNullable(new MortgageLoanDto()));
		when(mls.update(mortgageLoanDto)).thenReturn(Optional.ofNullable(new MortgageLoanDto()));
	}
	
	
	
}
