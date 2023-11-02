package com.tech.challenge.parking.meter.api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "extrato_alocacao")
public class ExtratoAlocacao {

    @Id
    @SequenceGenerator(name = "extrato_alocacao_seq",
            sequenceName = "extrato_alocacao_seq", allocationSize = 1)
    @GeneratedValue(generator = "extrato_alocacao_seq")
    @Column(name = "id", unique = true)
    @NotNull(message = "id should not be null")
    private Long id;
    @Column(name = "alocacao_id", unique = true)
    @NotNull(message = "alocacao_id should not be null")
    private Long alocacaoId;
    @NotNull(message = "placa should not be null")
    @NotEmpty(message = "placa should not be empty")
    @Column(name = "placa")
    private String placa;
    @Column(name = "horas_estadia")
    private Integer horasEstadia;
    @Column(name = "valor_calculado")
    private BigDecimal valorCalculado;
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
