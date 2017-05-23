package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.CashLoanDto;
import isi.project.banking.model.CashLoan;

@Component
public class CashLoanMapper implements BaseMapper<CashLoan, CashLoanDto> {

	@Autowired
	CashSupervisorMapper cashSupervisorMapper;
	@Autowired
	AccountMapper accountMapper;

	@Override
	public CashLoanDto map(CashLoan from) {
		return CashLoanDto.builder()
				.id(from.getId())
				.installments(from.getInstallments())
				.interest(from.getInterest())
				.sum(from.getSum())
				.grantDate(from.getGrantDate())
				.repaymentDate(from.getRepaymentDate())
				.settledInterest(from.getSettledInterest())
				.accNr(from.getAccNr())
				.provider(from.getProvider())
				.cashSupervisor(cashSupervisorMapper.map(from.getCashSupervisor()))
				.account(accountMapper.map(from.getAccount()))
				.build();
	}

	@Override
	public CashLoan unmap(CashLoanDto from) {
		return CashLoan.builder()
				.id(from.getId())
				.installments(from.getInstallments())
				.interest(from.getInterest())
				.sum(from.getSum())
				.grantDate(from.getGrantDate())
				.repaymentDate(from.getRepaymentDate())
				.settledInterest(from.getSettledInterest())
				.accNr(from.getAccNr())
				.provider(from.getProvider())
				.cashSupervisor(cashSupervisorMapper.unmap(from.getCashSupervisor()))
				.account(accountMapper.unmap(from.getAccount()))
				.build();
	}
	
}
