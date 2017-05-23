package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.DepositDto;
import isi.project.banking.model.Deposit;

@Component
public class DepositMapper implements BaseMapper<Deposit, DepositDto> {
	
	@Autowired
	AccountMapper accountMapper;

	@Override
	public DepositDto map(Deposit from) {
		return DepositDto.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public Deposit unmap(DepositDto from) {
		return Deposit.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
