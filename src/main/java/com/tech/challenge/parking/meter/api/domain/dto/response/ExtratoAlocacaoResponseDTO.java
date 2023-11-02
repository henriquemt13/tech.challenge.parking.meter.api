package com.tech.challenge.parking.meter.api.domain.dto.response;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExtratoAlocacaoResponseDTO {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Integer horasEstadia;
    private BigDecimal valorCalculado;
}
