package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.InvestmentDto;
import isi.project.banking.model.Investment;

@Component
public class InvestmentMapper implements BaseMapper<Investment, InvestmentDto> {

	@Autowired
	AccountMapper accountMapper;

	@Override
	public InvestmentDto map(Investment from) {
		return InvestmentDto.builder()
				.id(from.getId())
				.accNr(from.getAccNr())
				.openDate(from.getOpenDate())
				.closeDate(from.getCloseDate())
				.interest(from.getInterest())
				.balance(from.getBalance())
				.name(from.getName())
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public Investment unmap(InvestmentDto from) {
		return Investment.builder()
				.id(from.getId())
				.accNr(from.getAccNr())
				.openDate(from.getOpenDate())
				.closeDate(from.getCloseDate())
				.interest(from.getInterest())
				.balance(from.getBalance())
				.name(from.getName())
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
