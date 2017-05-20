package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import isi.project.banking.dto.ManagerDto;
import isi.project.banking.model.Manager;

public class ManagerMapper implements BaseMapper<Manager, ManagerDto> {

	@Autowired
	OfferCashLoanMapper offerCashLoanMapper;
	@Autowired
	OfferInvestmentMapper offerInvestmentMapper;
	@Autowired
	OfferMortgageLoanMapper offerMortgageLoanMapper;
	@Autowired
	RequestMapper requestMapper;

	@Override
	public ManagerDto map(Manager from) {
		return ManagerDto.builder()
				.pesel(from.getPesel())
				.login(from.getLogin())
				.password(from.getPassword())
				.firstName(from.getFirstName())
				.lastName(from.getLastName())
				.email(from.getEmail())
				.nrTel(from.getNrTel())
				.birthday(from.getBirthday())
				.cashLoanOffers(offerCashLoanMapper.map(from.getCashLoanOffers()))
				.investmentOffers(offerInvestmentMapper.map(from.getInvestmentOffers()))
				.mortgageLoanOffers(offerMortgageLoanMapper.map(from.getMortgageLoanOffers()))
				.requests(requestMapper.map(from.getRequests()))
				.build();
	}

}
