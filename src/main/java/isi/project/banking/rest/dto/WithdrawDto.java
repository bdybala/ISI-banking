package isi.project.banking.rest.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawDto {

    private int id;
    private double amount;
    private Date orderDate;
    private Date executionDate;
    private String accNr;
}
