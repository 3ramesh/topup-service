package com.vanilla.topup.service.impl;

import com.vanilla.topup.constant.enums.TopupStatus;
import com.vanilla.topup.dto.request.TopupRequestDto;
import com.vanilla.topup.dto.response.TopupResponseDto;
import com.vanilla.topup.entity.Topup;
import com.vanilla.topup.integration.AccountClient;
import com.vanilla.topup.mapper.TopupMapper;
import com.vanilla.topup.repository.TopupRepository;
import com.vanilla.topup.service.TopupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class TopupServiceImpl implements TopupService {

    private final TopupRepository topupRepository;
    private final AccountClient accountClient;
    private final TopupMapper topupMapper;

    @Override
    public TopupResponseDto topup(TopupRequestDto requestDto) {
        log.info("Starting transfer from {} to {} amount {}", requestDto.fromAccount(),
                requestDto.toAccount(),
                requestDto.amount());
        Topup topup = saveInitialData(requestDto);

        TopupResponseDto response = accountClient.transferAmount(requestDto);
        if (TopupStatus.SUCCESS.name().equals(response.status())) {
            topup.markSuccess();
            log.info("Topup SUCCESS from {} to {} amount: {}",
                    response.fromAccount(), response.toAccount(), response.amount());
            response = TopupResponseDto.success(response.fromAccount(), response.toAccount(), response.amount());

        } else {
            topup.markFailed(response.message());
            log.warn("Topup FAILED from {} to {} amount: {}",
                    response.fromAccount(), response.toAccount(), response.message());
        }
        topupRepository.save(topup);

        return response;

    }


    private Topup saveInitialData(TopupRequestDto requestDto) {
        Topup topup = topupMapper.toEntity(requestDto);
        topup.setStatus(TopupStatus.INITIATED);
        return topupRepository.save(topup);
    }


}
