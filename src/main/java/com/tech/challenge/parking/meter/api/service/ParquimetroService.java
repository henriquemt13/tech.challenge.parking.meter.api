package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.repository.ParquimetroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParquimetroService {

    private ParquimetroRepository repository;
}
