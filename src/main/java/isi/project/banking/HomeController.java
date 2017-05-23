package isi.project.banking;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import isi.project.banking.dto.AbstractTransactionDto;
import isi.project.banking.dto.AccountDto;
import isi.project.banking.dto.ClientDto;
import isi.project.banking.dto.DepositDto;
import isi.project.banking.dto.TransferDto;
import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.model.AbstractTransaction;
import isi.project.banking.service.AccountService;
import isi.project.banking.service.ClientService;
import isi.project.banking.service.DepositService;
import isi.project.banking.service.TransferService;
import isi.project.banking.service.WithdrawService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ClientService clientService;
	@Autowired
	AccountService accountService;
	@Autowired
	DepositService depositService;
	@Autowired
	TransferService transferService;
	@Autowired
	WithdrawService withdrawService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		ClientDto client = (ClientDto) session.getAttribute("client");
		try {

			logger.info("Logged account: {}", client.getPesel());
			model.addAttribute("loggedClient", client);

			// last session access (in miliseconds)
			Date currentDate = new Date();
			if (currentDate.after(new Date(session.getLastAccessedTime())))
				model.addAttribute("lastAccessTimeInMs", currentDate.getTime());
			else
				model.addAttribute("lastAccessTimeInMs", session.getLastAccessedTime());

			// timeout period (in seconds)
			model.addAttribute("sessionTimeOutPeriodInMs", 1000 * session.getMaxInactiveInterval());

			// transfer history
			List<List<AbstractTransactionDto>> transferHistory = new ArrayList<List<AbstractTransactionDto>>();
			List<TransferDto> transfersTo = new LinkedList<>();
			List<TransferDto> transfersFrom = new LinkedList<>();
			List<DepositDto> deposits = new LinkedList<>();
			List<WithdrawDto> withdrawals = new LinkedList<>();
			// TODO transfer history with DTO
			for(AccountDto accountDto: client.getAccounts()) {
				transfersTo = transferService.findByReceiverAccNr(accountDto.getAccNr());
				transfersFrom = transferService.findBySenderAccNr(accountDto.getAccNr());
				deposits = depositService.findByAccountAccNr(accountDto.getAccNr());
				withdrawals = withdrawService.findByAccountAccNr(accountDto.getAccNr());
				List<AbstractTransactionDto> transfers = new LinkedList<>();
				transfers.addAll(transfersFrom);
				transfers.addAll(transfersTo);
				transfers.addAll(deposits);
				transfers.addAll(withdrawals);
				transfers.sort(new Comparator<AbstractTransactionDto>() {

					@Override
					public int compare(AbstractTransactionDto o1, AbstractTransactionDto o2) {
						if(o1.getOrderDate() == null || o2.getOrderDate() == null)
							return 0;
						return o1.getOrderDate().compareTo(o2.getOrderDate());
					}
				});
				transferHistory.add(transfers);
			}
			model.addAttribute("transferHistory", transferHistory);

			return "client/user_account";

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.info("Logged account: NOT LOGGED");
			return "index";
		}
	}


	//TODO
	@RequestMapping(value = "/invest", method = RequestMethod.GET)
	public String investments(Locale locale, Model model, HttpSession session) {
		return "main-investments";
	}

}
