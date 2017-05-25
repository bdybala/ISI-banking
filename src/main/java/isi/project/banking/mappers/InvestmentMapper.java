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
		InvestmentDto investmentDto = InvestmentDto.builder()
				.id(from.getId())
				.accNr(from.getAccNr())
				.openDate(from.getOpenDate())
				.closeDate(from.getCloseDate())
				.interest(from.getInterest())
				.balance(from.getBalance())
				.name(from.getName())
				.build();
		if(from.getAccount() != null) {
			investmentDto.setAccount(accountMapper.map(from.getAccount()));
		}
		return investmentDto;
	}

	@Override
	public Investment unmap(InvestmentDto from) {
		Investment investment = Investment.builder()
				.id(from.getId())
				.accNr(from.getAccNr())
				.openDate(from.getOpenDate())
				.closeDate(from.getCloseDate())
				.interest(from.getInterest())
				.balance(from.getBalance())
				.name(from.getName())
				.build();
		if(from.getAccount() != null) {
			investment.setAccount(accountMapper.unmap(from.getAccount()));
		}
		return investment;
	}
	
}
