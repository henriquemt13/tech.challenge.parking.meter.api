package com.tech.challenge.parking.meter.api.controller;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoInfosResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.service.AlocacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/veiculo")
@AllArgsConstructor
public class AlocacaoController {

    private final AlocacaoService service;

    @PostMapping
    @ApiResponse(description = "Void", responseCode = "201")
    @Operation(summary = "Create Veiculo", description = """
          # Registra nova entrada
          ---
          notes:
          - No campo 'tipo', informe CARRO ou MOTO;
          """)
    public ResponseEntity<Void> createEntrada(
          @RequestBody @Valid String placa) {
        service.createEntrada(placa);
        return ResponseEntity.status(HttpStatus.OK)
              .build();
    }

    @PostMapping
    @ApiResponse(description = "Alocacao Response", responseCode = "201")
    @Operation(summary = "Create Saida", description = """
          # Registra nova saída
          ---
          notes:
          - No campo 'tipo', informe CARRO ou MOTO;
          """)
    public ResponseEntity<AlocacaoResponseDTO> createSaida(
          @RequestBody @Valid String placa) {
        return ResponseEntity.status(HttpStatus.CREATED)
              .body(service.createSaida(placa));
    }

    @GetMapping
    @ApiResponse(description = "AlocacaoInfos response", responseCode = "200")
    @Operation(summary = "Get Current AlocacaoInfos", description = """
          # Busca as informações de alocação no momento atual
          ---
          notes:
          - Este endpoint deve retornar informações como: número de vagas disponíveis e alocadas;
          """)
    public ResponseEntity<AlocacaoInfosResponseDTO> getInfos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAlocacaoInfos());
    }
}
