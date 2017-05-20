package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.TransferDto;
import isi.project.banking.model.Transfer;

@Component
public class TransferMapper implements BaseMapper<Transfer, TransferDto> {

	@Autowired
	AccountMapper accountMapper;

	@Override
	public TransferDto map(Transfer from) {
		return TransferDto.builder()
				.id(from.getId())
				.amount(from.getAmount())
				.orderDate(from.getOrderDate())
				.executionDate(from.getExecutionDate())
				.accNrSender(from.getAccNrSender())
				.accNrReceiver(from.getAccNrReceiver())
				.title(from.getTitle())
				.sender(accountMapper.map(from.getSender()))
				.receiver(accountMapper.map(from.getReceiver()))
				.build();
	}

}
