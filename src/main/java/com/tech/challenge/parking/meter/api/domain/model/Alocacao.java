package com.tech.challenge.parking.meter.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import org.hibernate.annotations.CreationTimestamp;

public class Alocacao {

    @Id
    @SequenceGenerator(name = "parquimetro_seq",
          sequenceName = "parquimetro_seq", allocationSize = 1)
    @GeneratedValue(generator = "parquimetro_seq")
    @Column(name = "id", unique = true)
    @NotNull(message = "id should not be null")
    private Long id;
    @NotNull(message = "precoInicial should not be null")
    @NotEmpty(message = "precoInicial should not be empty")
    @Column(name = "preco_inicial")
    private String placa;
    @NotNull(message = "entrada should not be null")
    @Column(name = "entrada")
    private OffsetDateTime entrada;
    @NotNull(message = "saida should not be null")
    @Column(name = "saida")
    private OffsetDateTime saida;
    @Column(name = "created_at")
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @NotNull(message = "Please enter createdBy")
    @NotBlank(message = "Please enter createdBy")
    @Column(name = "created_by")
    private String createdBy;

}
