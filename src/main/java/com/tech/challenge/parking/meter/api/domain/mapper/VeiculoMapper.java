package com.tech.challenge.parking.meter.api.domain.mapper;

import com.tech.challenge.parking.meter.api.domain.dto.request.VeiculoRequestDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.VeiculoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface VeiculoMapper {

    Veiculo of(VeiculoRequestDTO requestDTO);

    VeiculoResponseDTO of(Veiculo veiculo);
}
