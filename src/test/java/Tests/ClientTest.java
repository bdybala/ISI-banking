package Tests;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import isi.project.banking.model.client.Client;
import isi.project.banking.model.client.ClientService;
import isi.project.banking.model.offerInvestment.OfferInvestment;
import isi.project.banking.model.offerInvestment.OfferInvestmentService;

public class ClientTest {
	
	private Client client;
	private ClientService clientService;
	
	@Before
	public void setupMock()
	{
		client = mock(Client.class);
		clientService = mock(ClientService.class);
	}
	
	@Test
	public void testMockCreation(){
		assertNotNull(client);
		assertNotNull(clientService);
	}

}
