package com.tech.challenge.parking.meter.api.domain.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ParquimetroResponseDTO {
    private BigDecimal precoInicial;
    private BigDecimal horasPrecoInicial;
    private BigDecimal precoHoraExtra;
    private Integer totalVagas;
}
