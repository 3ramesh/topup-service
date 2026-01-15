package com.vanilla.topup.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TopupRequestDto(

        @NotBlank(message = "From account must not be blank")
        String fromAccount,

        @NotBlank(message = "To account must not be blank")
        String toAccount,

        @NotNull(message = "Topup amount must not be null")
        @Positive(message = "Topup amount must be greater than zero")
        BigDecimal amount

) {
}