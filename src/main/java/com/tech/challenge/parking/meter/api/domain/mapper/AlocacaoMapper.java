package com.tech.challenge.parking.meter.api.domain.mapper;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.model.Alocacao;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface AlocacaoMapper {

    AlocacaoResponseDTO of(Alocacao alocacao);
}
