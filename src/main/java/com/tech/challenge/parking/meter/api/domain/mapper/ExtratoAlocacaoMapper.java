package com.tech.challenge.parking.meter.api.domain.mapper;

import com.tech.challenge.parking.meter.api.domain.dto.response.ExtratoAlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.model.Alocacao;
import com.tech.challenge.parking.meter.api.domain.model.ExtratoAlocacao;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface ExtratoAlocacaoMapper {

    ExtratoAlocacaoResponseDTO of(ExtratoAlocacao extratoALocacao, Alocacao alocacao);
}
