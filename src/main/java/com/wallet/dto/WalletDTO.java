package com.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {

    private Long id;

    @Length(min = 3, message = "Nome deve conter no minimo 3 caracteres")
    @NotNull(message = "Nome não pode ser nulo")
    private String name;

    @NotNull(message = "Coloque um valor para a carteira")
    private BigDecimal value;
}
