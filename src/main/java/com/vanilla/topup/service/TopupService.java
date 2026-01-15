package com.vanilla.topup.service;

import com.vanilla.topup.dto.request.TopupRequestDto;
import com.vanilla.topup.dto.response.TopupResponseDto;


public interface TopupService {
    TopupResponseDto topup(TopupRequestDto requestDto);
}
