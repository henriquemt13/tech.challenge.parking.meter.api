package com.tech.challenge.parking.meter.api.domain.dto.response;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlocacaoResponseDTO {

    private String placa;
    private Time tempoAlocado;
    private String precoAPagar;

}
