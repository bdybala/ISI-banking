package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.BankerDto;
import isi.project.banking.model.Banker;

@Component
public class BankerMapper implements BaseMapper<Banker, BankerDto> {

	@Override
	public BankerDto map(Banker from) {
		return BankerDto.builder()
				.pesel(from.getPesel())
				.login(from.getLogin())
				.password(from.getPassword())
				.firstName(from.getFirstName())
				.lastName(from.getLastName())
				.email(from.getEmail())
				.nrTel(from.getNrTel())
				.birthday(from.getBirthday())
				.build();
	}

}
