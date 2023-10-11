package com.tech.challenge.parking.meter.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Parquimetro {

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
    private BigDecimal precoInicial;
    @NotNull(message = "horasPrecoInicial should not be null")
    @NotEmpty(message = "horasPrecoInicial should not be empty")
    @Column(name = "horas_preco_inicial")
    private BigDecimal horasPrecoInicial;
    @NotNull(message = "precoHoraExtra should not be null")
    @NotEmpty(message = "precoHoraExtra should not be empty")
    @Column(name = "preco_hora_extra")
    private BigDecimal precoHoraExtra;
    @Column(name = "created_at")
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @NotNull(message = "Please enter createdBy")
    @NotBlank(message = "Please enter createdBy")
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
    @Column(name = "updated_by")
    private String updatedBy;
}
