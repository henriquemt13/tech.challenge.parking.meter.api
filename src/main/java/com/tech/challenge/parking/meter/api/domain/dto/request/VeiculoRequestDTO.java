package com.tech.challenge.parking.meter.api.domain.dto.request;

import com.tech.challenge.parking.meter.api.enums.TipoVeiculoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;

@Data
public class VeiculoRequestDTO {

    @NotNull(message = "placa should not be null")
    private String placa;
    @NotNull(message = "tipoVeiculo should not be null")
    private TipoVeiculoEnum tipoVeiculo;
    @NotNull(message = "Please enter message")
    @NotBlank(message = "Please enter message")
    private String modelo;
    @NotNull(message = "Please enter cor")
    @NotBlank(message = "Please enter cor")
    private String cor;
    @NotNull(message = "Please enter ano")
    private Date ano;
    @NotNull(message = "Please enter nomeDono")
    @NotBlank(message = "Please enter nomeDono")
    private String nomeDono;
    @NotNull(message = "Please enter contatoDono")
    @NotBlank(message = "Please enter contatoDono")
    private String contatoDono;
}