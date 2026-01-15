package com.vanilla.topup.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TopupRequestDto(

        @NotNull(message = "From account must not be null")
        String fromAccount,

        @NotNull(message = "To account must not be null")
        String toAccount,

        @NotNull(message = "Topup amount must not be null")
        BigDecimal amount

) {
}