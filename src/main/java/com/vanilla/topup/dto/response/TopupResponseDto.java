package com.vanilla.topup.dto.response;

import com.vanilla.topup.constant.enums.TopupStatus;
import com.vanilla.topup.dto.request.TopupRequestDto;

import java.math.BigDecimal;

import static com.vanilla.topup.constant.enums.TopupStatus.SUCCESS;

public record TopupResponseDto(
        String fromAccount,
        String toAccount,
        BigDecimal amount,
        String status,
        String message
) {

    public static TopupResponseDto success(String fromAccount, String toAccount, BigDecimal amount) {
        return new TopupResponseDto(fromAccount, toAccount, amount, SUCCESS.name(), "Topup completed successfully");
    }

}
