package com.tech.challenge.parking.meter.api.domain.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UpdateParquimetroRequestDTO {

    private BigDecimal precoInicial;
    private BigDecimal horasPrecoInicial;
    private BigDecimal precoHoraExtra;
}
