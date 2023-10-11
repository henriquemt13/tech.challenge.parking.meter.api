package com.tech.challenge.parking.meter.api.domain.mapper;

import org.mapstruct.*;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface EletrodomesticoMapper {


    Eletrodomestico eletrodomesticoDTOToEletrodomesticoModel(EletrodomesticoDTO eletrodomesticoDTO);

    Eletrodomestico eletrodomesticoDTOToEletrodomesticoModel(EletrodomesticoDTO eletrodomesticoDTO, Long pessoaId);

    @Named("updateEletrodomesticoFromUpdateEletrodomesticoDTO")
    @Mapping(target = "id", ignore = true)
    Eletrodomestico updateEletrodomesticoFromUpdateEletrodomesticoDTO(
            UpdateEletrodomesticoDTO dto, @MappingTarget Eletrodomestico eletrodomestico);

    EletrodomesticoDetailDTO eletrodomesticoToEletrodomesticoDetailDTO(Eletrodomestico eletrodomestico);
}
