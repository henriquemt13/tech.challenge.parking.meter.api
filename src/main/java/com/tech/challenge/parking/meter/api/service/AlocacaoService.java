package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoInfosResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.repository.AlocacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlocacaoService {

    private final AlocacaoRepository repository;
    private final ParquimetroService parquimetroService;
    private final VeiculoService veiculoService;

    public void createEntrada(String placa) {

    }

    public AlocacaoResponseDTO createSaida(String placa) {
        return new AlocacaoResponseDTO("", null, null);
    }

    public AlocacaoInfosResponseDTO getAlocacaoInfos() {
        return new AlocacaoInfosResponseDTO(null, null, null, null);
    }
}
