package isi.project.banking.mappers;

import org.springframework.stereotype.Component;

import isi.project.banking.dto.ManagerDto;
import isi.project.banking.model.Manager;

@Component
public class ManagerMapper implements BaseMapper<Manager, ManagerDto> {

	@Override
	public ManagerDto map(Manager from) {
		return ManagerDto.builder()
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
	public Manager unmap(ManagerDto from) {
		return Manager.builder()
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
