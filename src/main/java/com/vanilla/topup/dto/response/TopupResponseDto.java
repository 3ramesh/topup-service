package com.vanilla.topup.dto.response;

import com.vanilla.topup.constant.enums.TopupStatus;
import com.vanilla.topup.dto.request.TopupRequestDto;

import java.math.BigDecimal;

public record TopupResponseDto(

        String fromAccount,
        String toAccount,
        BigDecimal amount,
        String status,
        String message

) {

}
