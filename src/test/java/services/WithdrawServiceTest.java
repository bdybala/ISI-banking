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

import isi.project.banking.dto.TransferDto;
import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.mappers.WithdrawMapper;
import isi.project.banking.repository.WithdrawRepository;
import isi.project.banking.service.WithdrawService;
import isi.project.banking.service.impl.WithdrawServiceImpl;

public class WithdrawServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
	WithdrawRepository withdrawRepository;

	@Mock
	WithdrawMapper withdrawMapper;
	
	@Mock
	WithdrawDto wd;
	
	@Mock
	WithdrawService ws;
	
	@InjectMocks
	WithdrawServiceImpl wsi;
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(wsi).build();
	}
	
	@Test
	public void findOnetest()
	{
		Integer id=0;
		
		when(ws.findOne(id)).thenReturn(Optional.ofNullable( new WithdrawDto() ));	
	}
	
	@Test
	public void findAllTest()
	{
		List<WithdrawDto> list = new ArrayList<WithdrawDto>();
		list.add(new WithdrawDto());
		
		when(wsi.findAll()).thenReturn(list);
	}
	
	@Test
	public void saveAndUpdateTest()
	{
		when(ws.save(wd)).thenReturn(Optional.ofNullable(new WithdrawDto()));
		when(ws.update(wd)).thenReturn(Optional.ofNullable(new WithdrawDto()));
	}
	
	
	
	
}
