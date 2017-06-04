package isi.project.banking.rest.mapper;

import isi.project.banking.rest.dto.WithdrawDto;
import isi.project.banking.rest.model.Withdraw;
import org.springframework.stereotype.Component;

@Component
public class WithdrawMapper implements BaseMapper<Withdraw, WithdrawDto> {

	@Override
	public WithdrawDto map(Withdraw from) {
		return WithdrawDto.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
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
				.build();
	}
	
}
