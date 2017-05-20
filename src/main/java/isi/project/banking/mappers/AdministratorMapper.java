package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.AdministratorDto;
import isi.project.banking.model.Administrator;

@Component
public class AdministratorMapper implements BaseMapper<Administrator, AdministratorDto> {

	@Override
	public AdministratorDto map(Administrator from) {
		return AdministratorDto.builder()
				.id(from.getId())
				.login(from.getLogin())
				.password(from.getPassword())
				.build();
	}

}
