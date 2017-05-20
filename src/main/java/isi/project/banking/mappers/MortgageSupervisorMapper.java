package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.MortgageSupervisorDto;
import isi.project.banking.model.MortgageSupervisor;

@Component
public class MortgageSupervisorMapper implements BaseMapper<MortgageSupervisor, MortgageSupervisorDto> {

	@Autowired
	RequestMapper requestMapper;
	@Autowired
	MortgageLoanMapper mortgageLoanMapper;

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
				.requests(requestMapper.map(from.getRequests()))
				.mortgageLoans(mortgageLoanMapper.map(from.getMortgageLoans()))
				.build();
	}

}
