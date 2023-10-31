package com.tech.challenge.parking.meter.api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alocacao")
public class Alocacao {

    @Id
    @SequenceGenerator(name = "alocacao_seq",
          sequenceName = "alocacao_seq", allocationSize = 1)
    @GeneratedValue(generator = "alocacao_seq")
    @Column(name = "id", unique = true)
    @NotNull(message = "id should not be null")
    private Long id;
    @NotNull(message = "placa should not be null")
    @NotEmpty(message = "placa should not be empty")
    @Column(name = "placa")
    private String placa;
    @Column(name = "entrada")
    private LocalDateTime entrada;
    @Column(name = "saida")
    private LocalDateTime saida;
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
