package com.vanilla.topup.mapper;

import com.vanilla.topup.dto.request.TopupRequestDto;
import com.vanilla.topup.dto.response.TopupResponseDto;
import com.vanilla.topup.entity.Topup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopupMapper {

    Topup toEntity(TopupRequestDto dto);

    TopupResponseDto toDto(Topup entity);
}