package isi.project.banking.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobilePaymentDto {

    private Double amount;
    private String tagCode;
    private String pin;
}
