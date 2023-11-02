package com.tech.challenge.parking.meter.api.controller;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoInfosResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.service.AlocacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/alocacao")
public class AlocacaoController {

    private final AlocacaoService service;
    @PostMapping(value = "/entrada/{placa}")
    @ApiResponse(description = "Void", responseCode = "201")
    @Operation(summary = "Create Veiculo", description = """
          # Registra nova entrada
          ---
          notes:
          - Veiculo precisa existir no banco e não ter registros de entrada, ou entrada sem saída;
          """)
    public ResponseEntity<Void> createEntrada(
            @PathVariable("placa") String placa) {
        service.createEntrada(placa);
        return ResponseEntity.status(HttpStatus.OK)
              .build();
    }

    @PostMapping(value = "/saida/{placa}")
    @ApiResponse(description = "Alocacao Response", responseCode = "201")
    @Operation(summary = "Create Saida", description = """
          # Registra nova saída
          ---
          notes:
          - Veiculo precisa existir no banco e ter um registro de entrada;
          """)
    public ResponseEntity<Void> createSaida(
            @PathVariable("placa") String placa) {
        service.createSaida(placa);
        return ResponseEntity.status(HttpStatus.CREATED)
              .build();
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
