package com.tech.challenge.parking.meter.api.domain.dto.response;

import lombok.Data;

@Data
public class AlocacaoResponseDTO {

    private Integer vagasAlocadas;
    private Integer vagasDisponiveis;
    private Integer numeroMotosAlocadas;
    private Integer numeroCarroAlocados;
}
