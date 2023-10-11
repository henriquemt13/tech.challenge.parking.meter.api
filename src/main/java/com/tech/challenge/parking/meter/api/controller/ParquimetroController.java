package com.tech.challenge.parking.meter.api.controller;

import com.tech.challenge.parking.meter.api.domain.dto.request.UpdateParquimetroDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.ParquimetroResponseDTO;
import com.tech.challenge.parking.meter.api.service.ParquimetroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/api/v1/parquimetro")
public class ParquimetroController {

    private final ParquimetroService service;

    @PutMapping("/{placa}")
    @ApiResponse(description = "Void", responseCode = "200")
    @Operation(summary = "Update Parquimetro Params", description = """
          # Atualiza parâmetros do parquimetro
          ---
          notes:
          - Este endpoint deve atualizar os seguintes parâmetros: precoIncial; horasPrecoInicial 
          precoHoraExtra;
          """)
    public ResponseEntity<Void> updateParquimetroParams(
          @RequestBody @Valid UpdateParquimetroDTO parquimetroDTO) {
        service.update(parquimetroDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @ApiResponse(description = "Parquimetro response", responseCode = "200")
    @Operation(summary = "Get Parquietro Params", description = """
          # Busca os parâmetros atuais do parquimetro
          ---
          notes:
          - Este endpoint deve trazer todos os parâmetros atuais do parquimetro;
          """)
    public ResponseEntity<ParquimetroResponseDTO> getParquimetroParams() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
