package banking;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import isi.project.banking.controller.CardController;
import isi.project.banking.model.Card;
import isi.project.banking.model.CardService;



public class CardTest {

	@Mock
	private Logger logger;
	
	@Mock
	private CardService cardService;
	

	
	@Mock
	private EntityManager em;
	
	@Mock
	HttpSession http;
	
	@Mock
	Model model;
	
	@InjectMocks
	private CardController cardController;
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		mockMvc=MockMvcBuilders.standaloneSetup(cardController).build();
	}
	
	@Test
	public void testMocks()
	{

		assertNotNull(em);
		assertNotNull(model);
		assertNotNull(cardService);
		assertNotNull(logger);
		assertNotNull(http);
		
	}
	
	
	@Test
	public void testInvestmentList() throws Exception
	{
		List<Card> card = new ArrayList<Card>();
		card.add(new Card());
		card.add(new Card());
		
		//when(offerController.investments(locale, model, http)).thenReturn((List) investment);
		when(cardService.findAllCard()).thenReturn(card);
	}
	
	
	
}
