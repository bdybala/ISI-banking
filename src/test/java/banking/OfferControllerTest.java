package banking;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import isi.project.banking.controller.OfferController;
import isi.project.banking.model.Investment;
import isi.project.banking.model.OfferCashLoan;

import isi.project.banking.model.OfferInvestment;

import isi.project.banking.model.OfferMortgageLoan;



@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class OfferControllerTest {
	
	@Mock
	private Logger logger;
	
	@Mock
	private OfferInvestmentService investmentService;
	
	@Mock
	private OfferCashLoanService cashService;
	
	@Mock
	private OfferMortgageLoanService mortgageService;
	
	@Mock
	private EntityManager em;
	

	
	@Mock
	HttpSession http;
	
	@Mock
	Model model;
	
	@InjectMocks
	private OfferController offerController;
	private MockMvc mockMvc;
	@InjectMocks
	private OfferMortgageLoan mortgageController;
	@InjectMocks
	private OfferCashLoan cashController;
	//private MockHttpSession mhttp;
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		mockMvc=MockMvcBuilders.standaloneSetup(offerController).build();
	}
	
	@Test
	public void testMocks()
	{
		assertNotNull(em);
		assertNotNull(model);
		assertNotNull(investmentService);
		assertNotNull(logger);
		assertNotNull(http);
		
	}
	
	
	@Test
	public void testInvestmentList() throws Exception
	{
		List<OfferInvestment> investment = new ArrayList<OfferInvestment>();
		investment.add(new OfferInvestment());
		investment.add(new OfferInvestment());
		
		//when(offerController.investments(locale, model, http)).thenReturn((List) investment);
		when(investmentService.findAllOfferInvestments()).thenReturn(investment);
	}
	
	
	@Test
	public void testCashList() throws Exception
	{
		List<OfferCashLoan> cash = new ArrayList<OfferCashLoan>();
		cash.add(new OfferCashLoan());
		cash.add(new OfferCashLoan());
		
		//when(offerController.investments(locale, model, http)).thenReturn((List) investment);
		when(cashService.findAllOfferCashLoan()).thenReturn(cash);
	}
	
	
	@Test
	public void testMortgageList() throws Exception
	{
		List<OfferMortgageLoan> mortgage = new ArrayList<OfferMortgageLoan>();
		mortgage.add(new OfferMortgageLoan());
		mortgage.add(new OfferMortgageLoan());
		
		//when(offerController.investments(locale, model, http)).thenReturn((List) investment);
		when(mortgageService.findAllOfferMortgageLoan()).thenReturn(mortgage);
	}
	
	
	
	@Test
	public void testShow() throws Exception
	{
		int id =1;
		when(offerController.investments(model, http)).thenReturn("client/offer-investments");
		
		//mockMvc.perform(get("/offer-loans")).andExpect(Vie);
	
//		mockMvc.perform((RequestBuilder) investmentService.findAllOfferInvestments()).andExpect(status().isOk())
	//	mockMvc.perform()
	}
}
