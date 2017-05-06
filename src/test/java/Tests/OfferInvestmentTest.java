package Tests;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import isi.project.banking.model.offerInvestment.OfferInvestment;
import isi.project.banking.model.offerInvestment.OfferInvestmentService;


public class OfferInvestmentTest {
	
	private OfferInvestment offerInvestment;
	private OfferInvestmentService offerInvestmentService;
	
	@Before
	public void setupMock()
	{
		offerInvestment = mock(OfferInvestment.class);
		offerInvestmentService = mock(OfferInvestmentService.class);
	}

	@Test
	public void testMockCreation(){
		assertNotNull(offerInvestment);
		assertNotNull(offerInvestmentService);
	}
	
	@Test
	public void testFindOfferInvestment()
	{
		when(offerInvestmentService.findOfferInvestment(0)).thenReturn(offerInvestment);
		assertEquals(0,offerInvestmentService.findOfferInvestment(0));
	}
}
