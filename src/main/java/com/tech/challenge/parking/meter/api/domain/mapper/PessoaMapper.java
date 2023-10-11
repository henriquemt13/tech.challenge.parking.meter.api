package com.tech.challenge.parking.meter.api.domain.mapper;

import com.tech.challenge.energy.consumption.api.domain.dto.*;

import org.mapstruct.*;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PessoaMapper {

    Pessoa pessoaRequestDTOToPessoaModel(PessoaRequestDTO pessoaRequestDTO);

    @Named("updateUserFromUserDto")
    @Mapping(target = "id", ignore = true)
    Pessoa updatePessoaFromUpdatePessoaDTO(UpdatePessoaDTO dto, @MappingTarget Pessoa pessoa);

    PessoaDetailDTO pessoaAndParenteDTOsToPessoaDetailDTO(Pessoa pessoa, List<ParenteDTO> parentes);

    PessoaDTO pessoaToPessoaDTO(Pessoa pessoa);

    Pessoa pessoaToPessoaModel(PessoaDTO pessoaDTO);

    List<PessoaRequestDTO> pessoasToPessoaDTOs(List<Pessoa> pessoas);
}
