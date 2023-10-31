package com.tech.challenge.parking.meter.api.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlocacaoInfosResponseDTO {

    private Integer vagasAlocadas;
    private Integer vagasDisponiveis;
    private Integer numeroMotosAlocadas;
    private Integer numeroCarroAlocados;
}
