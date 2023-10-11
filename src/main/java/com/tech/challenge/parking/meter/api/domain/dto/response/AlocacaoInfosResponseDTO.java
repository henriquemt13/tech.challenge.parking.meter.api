package com.tech.challenge.parking.meter.api.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlocacaoInfosResponseDTO {

    private Integer vagasAlocadas;
    private Integer vagasDisponiveis;
    private Integer numeroMotosAlocadas;
    private Integer numeroCarroAlocados;
}
