package isi.project.banking.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobilePaymentDto {

    private Double amount;
    private String nfcValue;
    private String pin;
}
