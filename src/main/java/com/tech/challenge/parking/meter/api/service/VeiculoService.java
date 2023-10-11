package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.domain.dto.request.VeiculoRequestDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.VeiculoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.mapper.VeiculoMapper;
import com.tech.challenge.parking.meter.api.repository.VeiculoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VeiculoService {

    private VeiculoRepository repository;
    private VeiculoMapper mapper;

    public VeiculoResponseDTO save(VeiculoRequestDTO requestDTO) {
        if (!veiculoExists(requestDTO.getPlaca())) {
            repository.save(mapper.of(requestDTO));
        }
        throw new RuntimeException();
    }

    public List<VeiculoResponseDTO> findByFilter(VeiculoRequestDTO requestDTO) {
        return List.of(new VeiculoResponseDTO());
    }

    public void update(String currentPlaca, VeiculoRequestDTO veiculoRequestDTO) {
        if (veiculoExists(currentPlaca)) {
            repository.save(mapper.of(veiculoRequestDTO));
        }
    }

    public boolean veiculoExists(String placa) {
        return repository.existsById(placa);
    }
}
