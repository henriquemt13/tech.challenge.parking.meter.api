package com.tech.challenge.parking.meter.api.controller;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoInfosResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.ExtratoAlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.service.ExtratoAlocacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/extrato")
public class ExtratoAlocacaoController {
    private final ExtratoAlocacaoService service;

    @GetMapping("/{placa}")
    @ApiResponse(description = "ExtratoAlocacaoResponseDTO response", responseCode = "200")
    @Operation(summary = "Get All Extratos by Placa", description = """
          # Busca as todas as infomações de Extrado de Alocações por placa
          ---
          notes:
          - Este endpoint deve retornar informações como: as horas de entrada e saída, tempo de estadia e valor a pagar;
          """)
    public ResponseEntity<List<ExtratoAlocacaoResponseDTO>> getAllExtratosByPlaca(@PathVariable("placa") String placa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getExtratosAlocacao(placa));
    }

    @GetMapping("/lastExtrato/{placa}")
    @ApiResponse(description = "ExtratoAlocacaoResponseDTO response", responseCode = "200")
    @Operation(summary = "Get Last Extrato by Placa", description = """
          # Busca a ultima infomação de Extrado de Alocações por placa
          ---
          notes:
          - Este endpoint deve retornar informações como: as horas de entrada e saída, tempo de estadia e valor a pagar;
          """)
    public ResponseEntity<ExtratoAlocacaoResponseDTO> getLastExtratoByPlaca(@PathVariable("placa") String placa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getLastExtratoAlocacao(placa));
    }
}
