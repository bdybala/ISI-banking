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
		WithdrawDto withdrawDto = WithdrawDto.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.build();
		if(from.getAccount() != null ) 
			withdrawDto.setAccount(accountMapper.map(from.getAccount()));
		return withdrawDto;
		
	}

	@Override
	public Withdraw unmap(WithdrawDto from) {
		Withdraw withdraw = Withdraw.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNr(from.getAccNr())
				.build();
		if(from.getAccount() != null ) 
			withdraw.setAccount(accountMapper.unmap(from.getAccount()));
		return withdraw;
		
	}
	
}
