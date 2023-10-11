package com.tech.challenge.parking.meter.api.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface ResidentesEnderecoMapper {

    ResidenteEnderecoDTO residenteEnderecoToResidenteEnderecoDTO(ResidenteEndereco residenteEndereco);

    List<ResidenteEnderecoDTO> residenteEnderecoToResidenteEnderecoDTO(List<ResidenteEndereco> residenteEndereco);

    ResidenteEndereco residenteEnderecoDTOToResidenteEndereco(ResidenteEnderecoDTO residenteEnderecoDTO);
}
