package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.OfferInvestmentDto;
import isi.project.banking.model.OfferInvestment;

@Component
public class OfferInvestmentMapper implements BaseMapper<OfferInvestment, OfferInvestmentDto> {

	@Autowired
	ManagerMapper managerMapper;
	
	@Override
	public OfferInvestmentDto map(OfferInvestment from) {
		return OfferInvestmentDto.builder()
				.id(from.getId())
				.name(from.getName())
				.interest(from.getInterest())
				.interestType(from.getInterestType())
				.duration(from.getDuration())
				.minSum(from.getMinSum())
				.maxSum(from.getMaxSum())
				.author(from.getAuthor())
				.manager(managerMapper.map(from.getManager()))
				.build();
	}

	@Override
	public OfferInvestment unmap(OfferInvestmentDto from) {
		return OfferInvestment.builder()
				.id(from.getId())
				.name(from.getName())
				.interest(from.getInterest())
				.interestType(from.getInterestType())
				.duration(from.getDuration())
				.minSum(from.getMinSum())
				.maxSum(from.getMaxSum())
				.author(from.getAuthor())
				.manager(managerMapper.unmap(from.getManager()))
				.build();
	}
	
}
