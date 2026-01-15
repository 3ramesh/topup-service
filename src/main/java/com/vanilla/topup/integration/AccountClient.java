package com.vanilla.topup.integration;

import com.vanilla.topup.constant.enums.TopupStatus;
import com.vanilla.topup.dto.request.TopupRequestDto;
import com.vanilla.topup.dto.response.TopupResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountClient {

    private final RestClient restClient;

    @Value("${account-service.endpoints.transfer:/v1/accounts/transfer}")
    private String transferUri;

    public TopupResponseDto transferAmount(TopupRequestDto requestDto) {
        log.info("Calling Account service for topup: {} → {} amount {}",
                requestDto.fromAccount(), requestDto.toAccount(), requestDto.amount());

        try {
            return restClient.post()
                    .uri(transferUri)
                    .body(requestDto)
                    .retrieve()
                    .toEntity(TopupResponseDto.class)
                    .getBody();
        } catch (Exception ex) {
            log.error("Account service call failed: {}", ex.getMessage(), ex);
            return new TopupResponseDto(
                    requestDto.fromAccount(),
                    requestDto.toAccount(),
                    requestDto.amount(),
                    TopupStatus.FAILED.name(),
                    "Account service call failed: " + ex.getMessage()
            );
        }
    }
}
