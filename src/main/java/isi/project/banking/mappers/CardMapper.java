package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.CardDto;
import isi.project.banking.model.Card;

@Component
public class CardMapper implements BaseMapper<Card, CardDto> {

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public CardDto map(Card from) {
		return CardDto.builder()
				.cardNr(from.getCardNr())
				.accNr(from.getAccNr())
				.name(from.getName())
				.status(from.getStatus())
				.cvc(from.getCvc())
				.pin(from.getPin())
				.nfcValue(from.getNfcValue())
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public Card unmap(CardDto from) {
		return Card.builder()
				.cardNr(from.getCardNr())
				.accNr(from.getAccNr())
				.name(from.getName())
				.status(from.getStatus())
				.cvc(from.getCvc())
				.pin(from.getPin())
				.nfcValue(from.getNfcValue())
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
}
