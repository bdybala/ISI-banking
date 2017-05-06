package Tests;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import isi.project.banking.model.investment.Investment;
import isi.project.banking.model.investment.InvestmentService;


public class InvestmentTest {

	private Investment investment;
	private InvestmentService investmentService;
	
	@Before
	public void setupMock()
	{
		investment = mock(Investment.class);
		investmentService = mock(InvestmentService.class);
	}

	@Test
	public void testMockCreation(){
		assertNotNull(investment);
		assertNotNull(investmentService);
	}
	
}
