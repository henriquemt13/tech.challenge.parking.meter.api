package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.domain.dto.request.UpdateParquimetroDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.ParquimetroResponseDTO;
import com.tech.challenge.parking.meter.api.repository.ParquimetroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParquimetroService {

    private ParquimetroRepository repository;

    public void update(UpdateParquimetroDTO parquimetroDTO) {

    }

    public ParquimetroResponseDTO findAll() {
        return new ParquimetroResponseDTO();
    }
}
