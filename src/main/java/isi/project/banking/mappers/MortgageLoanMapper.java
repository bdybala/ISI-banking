package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.MortgageLoanDto;
import isi.project.banking.model.MortgageLoan;

@Component
public class MortgageLoanMapper implements BaseMapper<MortgageLoan, MortgageLoanDto> {

	@Autowired
	MortgageSupervisorMapper mortgageSupervisorMapper;
	@Autowired
	AccountMapper accountMapper;

	@Override
	public MortgageLoanDto map(MortgageLoan from) {
		return MortgageLoanDto.builder()
				.id(from.getId())
				.installments(from.getInstallments())
				.interest(from.getInterest())
				.sum(from.getSum())
				.grantDate(from.getGrantDate())
				.repaymentDate(from.getRepaymentDate())
				.settledInterest(from.getSettledInterest())
				.accNr(from.getAccNr())
				.provider(from.getProvider())
				.mortgageSupervisor(mortgageSupervisorMapper.map(from.getMortgageSupervisor()))
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public MortgageLoan unmap(MortgageLoanDto from) {
		return MortgageLoan.builder()
				.id(from.getId())
				.installments(from.getInstallments())
				.interest(from.getInterest())
				.sum(from.getSum())
				.grantDate(from.getGrantDate())
				.repaymentDate(from.getRepaymentDate())
				.settledInterest(from.getSettledInterest())
				.accNr(from.getAccNr())
				.provider(from.getProvider())
				.mortgageSupervisor(mortgageSupervisorMapper.unmap(from.getMortgageSupervisor()))
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
