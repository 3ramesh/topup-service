package com.vanilla.topup.controller;

import com.vanilla.topup.dto.request.TopupRequestDto;
import com.vanilla.topup.dto.response.TopupResponseDto;
import com.vanilla.topup.service.TopupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vanilla.topup.constant.ApiConstant.API_V1;
import static com.vanilla.topup.constant.ApiConstant.TOP_UPS;

@RestController
@RequestMapping(API_V1 + TOP_UPS)
@RequiredArgsConstructor
@Slf4j
public class TopupController {

    private final TopupService topupService;

    @PostMapping
    public ResponseEntity<TopupResponseDto> transfer(@Valid @RequestBody TopupRequestDto request) {
        log.info("Received topup request: {}", request);
        return ResponseEntity.ok(topupService.topup(request));
    }
}
