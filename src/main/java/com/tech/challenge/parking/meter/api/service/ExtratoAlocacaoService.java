package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.domain.dto.response.ExtratoAlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.ParquimetroResponseDTO;
import com.tech.challenge.parking.meter.api.domain.mapper.ExtratoAlocacaoMapper;
import com.tech.challenge.parking.meter.api.domain.model.Alocacao;
import com.tech.challenge.parking.meter.api.domain.model.ExtratoAlocacao;
import com.tech.challenge.parking.meter.api.exceptions.ExtratoAlocacaoNotFoundException;
import com.tech.challenge.parking.meter.api.exceptions.InvalidAlocacaoException;
import com.tech.challenge.parking.meter.api.repository.ExtratoAlocacaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ExtratoAlocacaoService {

    private final ParquimetroService parquimetroService;
    private final AlocacaoService alocacaoService;
    private final ExtratoAlocacaoRepository repository;
    private final ExtratoAlocacaoMapper mapper;

    public List<ExtratoAlocacaoResponseDTO> getExtratosAlocacao(String placa) {
        List<ExtratoAlocacao> extratos = repository.findByPlaca(placa);
        List<ExtratoAlocacaoResponseDTO> responses = new ArrayList<>();
        for (ExtratoAlocacao extrato : extratos) {
            responses.add(mapper.of(extrato, getAlocacaoById(extrato.getAlocacaoId())));
        }
        return responses;

    }

    public ExtratoAlocacaoResponseDTO getLastExtratoAlocacao(String placa) {
        ExtratoAlocacao extratoAlocacao = getLastExtratoByPlaca(placa);
        return mapper.of(extratoAlocacao, getAlocacaoById(extratoAlocacao.getAlocacaoId()));
    }

    public void saveNewExtrato(String placa) {
        var parquimetroInfos = parquimetroService.findInfos().get(0);
        var alocacao = alocacaoService.findLastAlocacao(placa);
        if (alocacao.isEmpty()) {
            throw new InvalidAlocacaoException(placa);
        }
        ExtratoAlocacao extrato = new ExtratoAlocacao();
        extrato.setAlocacaoId(alocacao.get().getId());
        extrato.setPlaca(placa);
        extrato.setHorasEstadia(getParkingTime(alocacao.get()));
        extrato.setValorCalculado(getFinalPrice(extrato.getHorasEstadia(), parquimetroInfos));
        extrato.setCreatedBy("System");
        repository.save(extrato);
    }

    private Integer getParkingTime(Alocacao alocacao) {
        return Duration.between(alocacao.getEntrada(), alocacao.getSaida()).toHoursPart();
    }

    private BigDecimal getFinalPrice(Integer parkingTime, ParquimetroResponseDTO parquimetro) {
        if (parkingTime > parquimetro.getHorasPrecoInicial()) {
            return parquimetro.getPrecoInicial()
                    .add(parquimetro.getPrecoHoraExtra()
                            .multiply(BigDecimal.valueOf(parkingTime - parquimetro.getHorasPrecoInicial())));
        }
        return parquimetro.getPrecoInicial();
    }


    public Alocacao getAlocacaoById(Long id) {
        Optional<Alocacao> alocacao = alocacaoService.getAlocacaoById(id);
        if (alocacao.isPresent()) {
            return alocacao.get();
        }
        throw new InvalidAlocacaoException(id);
    }

    private ExtratoAlocacao getLastExtratoByPlaca(String placa) {
        Optional<ExtratoAlocacao> extratoAlocacao = repository.findFirstByPlacaOrderByCreatedAtDesc(placa);
        if (extratoAlocacao.isPresent()) {
            return extratoAlocacao.get();
        }
        throw new ExtratoAlocacaoNotFoundException(placa);
    }
}
