package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import isi.project.banking.dto.OfferCashLoanDto;
import isi.project.banking.model.OfferCashLoan;

public class OfferCashLoanMapper implements BaseMapper<OfferCashLoan, OfferCashLoanDto> {

	@Autowired
	ManagerMapper managerMapper;

	@Override
	public OfferCashLoanDto map(OfferCashLoan from) {
		return OfferCashLoanDto.builder()
				.id(from.getId())
				.name(from.getName())
				.interest(from.getInterest())
				.interestType(from.getInterestType())
				.minSum(from.getMinSum())
				.maxSum(from.getMaxSum())
				.minInstallments(from.getMinInstallments())
				.maxInstallments(from.getMaxInstallments())
				.author(from.getAuthor())
				.manager(managerMapper.map(from.getManager()))
				.build();
	}

}
