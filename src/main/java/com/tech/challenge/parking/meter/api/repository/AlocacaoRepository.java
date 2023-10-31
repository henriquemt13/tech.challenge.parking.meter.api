package com.tech.challenge.parking.meter.api.repository;

import com.tech.challenge.parking.meter.api.domain.model.Alocacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

    List<Alocacao> findByPlaca(String placa);

    List<Alocacao> findBySaidaIsNull();

    Optional<Alocacao> findFirstByPlacaOrderByCreatedAtDesc(String placa);


}
