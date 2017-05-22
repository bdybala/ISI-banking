package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.RequestDto;
import isi.project.banking.model.Request;

@Component
public class RequestMapper implements BaseMapper<Request, RequestDto> {

	@Autowired
	ManagerMapper managerMapper;
	@Autowired
	CashSupervisorMapper cashSupervisorMapper;
	@Autowired
	MortgageSupervisorMapper mortgageSupervisorMapper;
	@Autowired
	AccountMapper accountMapper;

	@Override
	public RequestDto map(Request from) {
		return RequestDto.builder()
				.id(from.getId())
				.cause(from.getCause())
				.accNr(from.getAccNr())
				.applicantCash(from.getApplicantCash())
				.applicantMortgage(from.getApplicantMortgage())
				.manager(managerMapper.map(from.getManager()))
				.cashSupervisor(cashSupervisorMapper.map(from.getCashSupervisor()))
				.mortgageSupervisor(mortgageSupervisorMapper.map(from.getMortgageSupervisor()))
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public Request unmap(RequestDto from) {
		return Request.builder()
				.id(from.getId())
				.cause(from.getCause())
				.accNr(from.getAccNr())
				.applicantCash(from.getApplicantCash())
				.applicantMortgage(from.getApplicantMortgage())
				.manager(managerMapper.unmap(from.getManager()))
				.cashSupervisor(cashSupervisorMapper.unmap(from.getCashSupervisor()))
				.mortgageSupervisor(mortgageSupervisorMapper.unmap(from.getMortgageSupervisor()))
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
