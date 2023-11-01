package com.tech.challenge.parking.meter.api.repository;

import com.tech.challenge.parking.meter.api.domain.model.ExtratoAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ExtratoAlocacaoRepository extends JpaRepository<ExtratoAlocacao, Long> {

    List<ExtratoAlocacao> findByPlaca(String placa);

    Optional<ExtratoAlocacao> findFirstByPlacaOrderByCreatedAtDesc(String placa);
}
