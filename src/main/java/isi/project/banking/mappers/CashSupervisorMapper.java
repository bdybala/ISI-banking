package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.CashSupervisorDto;
import isi.project.banking.model.CashSupervisor;

@Component
public class CashSupervisorMapper implements BaseMapper<CashSupervisor, CashSupervisorDto> {

	@Autowired
	RequestMapper requestMapper;
	@Autowired
	CashLoanMapper cashLoanMapper;

	@Override
	public CashSupervisorDto map(CashSupervisor from) {
		return CashSupervisorDto.builder()
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
	public CashSupervisor unmap(CashSupervisorDto from) {
		return CashSupervisor.builder()
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
