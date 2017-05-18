package banking;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import isi.project.banking.controller.CardController;
import isi.project.banking.model.Account;
import isi.project.banking.model.OfferMortgageLoan;
import isi.project.banking.model.account.AccountService;


public class AccountTest {
	
	@Mock
	private Logger logger;
	
	@Mock
	private AccountService accService;

	@Mock
	private EntityManager em;
	
	@Mock
	HttpSession http;
	
	@Mock
	Model model;

	private MockMvc mockMvc;
	
	@Test
	public void testFindByIdList() throws Exception
	{
		String pesel="00000000000";
		List<Account> acc = new ArrayList<Account>();
		
		acc.add(new Account());
		acc.add(new Account());
		
		when(accService.findAccountsByPesel(pesel)).thenReturn(new Account());
	}
}
