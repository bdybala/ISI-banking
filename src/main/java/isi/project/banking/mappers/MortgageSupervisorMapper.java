package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.MortgageSupervisorDto;
import isi.project.banking.model.MortgageSupervisor;

@Component
public class MortgageSupervisorMapper implements BaseMapper<MortgageSupervisor, MortgageSupervisorDto> {

	@Override
	public MortgageSupervisorDto map(MortgageSupervisor from) {
		return MortgageSupervisorDto.builder()
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

	@Override
	public MortgageSupervisor unmap(MortgageSupervisorDto from) {
		return MortgageSupervisor.builder()
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
