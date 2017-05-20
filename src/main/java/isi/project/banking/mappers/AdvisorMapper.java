package isi.project.banking.mappers;

import isi.project.banking.dto.AdvisorDto;
import isi.project.banking.model.Advisor;

public class AdvisorMapper implements BaseMapper<Advisor, AdvisorDto> {

	@Override
	public AdvisorDto map(Advisor from) {
		return AdvisorDto.builder()
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
