package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.WithdrawDto;
import isi.project.banking.model.Withdraw;

@Component
public class WithdrawMapper implements BaseMapper<Withdraw, WithdrawDto> {

	@Autowired
	AccountMapper accountMapper;

	@Override
	public WithdrawDto map(Withdraw from) {
		return WithdrawDto.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public Withdraw unmap(WithdrawDto from) {
		return Withdraw.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
