package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VeiculoService {

    private VeiculoRepository repository;
}
