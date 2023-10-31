package com.tech.challenge.parking.meter.api.service;

import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoInfosResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.AlocacaoResponseDTO;
import com.tech.challenge.parking.meter.api.domain.dto.response.ParquimetroResponseDTO;
import com.tech.challenge.parking.meter.api.domain.mapper.AlocacaoMapper;
import com.tech.challenge.parking.meter.api.domain.model.Alocacao;
import com.tech.challenge.parking.meter.api.domain.model.Veiculo;
import com.tech.challenge.parking.meter.api.enums.TipoVeiculoEnum;
import com.tech.challenge.parking.meter.api.exceptions.InvalidAlocacaoException;
import com.tech.challenge.parking.meter.api.exceptions.VeiculoNotFoundException;
import com.tech.challenge.parking.meter.api.repository.AlocacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlocacaoService {

    private final AlocacaoRepository repository;
    private final ParquimetroService parquimetroService;
    private final VeiculoService veiculoService;
    private final AlocacaoMapper mapper;

    public void createEntrada(String placa) {
        if (!isEntradaValid(placa)) {
            throw new InvalidAlocacaoException(placa);
        }
        veiculoService.findByPlaca(placa).ifPresent(veiculo -> {
            Alocacao alocacao = new Alocacao();
            alocacao.setPlaca(placa);
            alocacao.setCreatedBy("System");
            alocacao.setEntrada(LocalDateTime.now());
            repository.save(alocacao);
        });
    }

    private boolean isEntradaValid(String placa) {
        var lastAlocacaoPlaca = findLastAlocacao(placa);
        return isNotFull()
                && (lastAlocacaoPlaca.isEmpty() || lastAlocacaoPlaca.get().getSaida() != null);
    }

    private boolean isNotFull() {
        return repository.findBySaidaIsNull().size() < parquimetroService.findInfos().get(0).getTotalVagas();
    }

    public AlocacaoResponseDTO createSaida(String placa) {
        var saida = validateSaida(placa);
        saida.setUpdatedBy("System");
        saida.setSaida(LocalDateTime.now());
        return calculateParkingPrice(repository.save(saida));
    }

    private Alocacao validateSaida(String placa) {
        veiculoService.veiculoExists(placa);
        var alocacao = findLastAlocacao(placa);
        if (alocacao.isPresent() && isSaidaValid(alocacao.get())) {
            return alocacao.get();
        }
        throw new InvalidAlocacaoException(placa);
    }

    private boolean isSaidaValid(Alocacao alocacao) {
        return alocacao.getSaida() == null;
    }

    public Optional<Alocacao> findLastAlocacao(String placa) {
        return repository.findFirstByPlacaOrderByCreatedAtDesc(placa);
    }

    public AlocacaoInfosResponseDTO getAlocacaoInfos() {
        var alocacoes = repository.findBySaidaIsNull();
        var veiculos = getVeiculos(alocacoes);
        return AlocacaoInfosResponseDTO.builder()
                .vagasAlocadas(alocacoes.size())
                .vagasDisponiveis(parquimetroService.getTotalVagas() - alocacoes.size())
                .numeroCarroAlocados(countCarros(veiculos))
                .numeroMotosAlocadas(countMotos(veiculos))
                .build();
    }

    private List<Veiculo> getVeiculos(List<Alocacao> alocacoes) {
        List<Veiculo> veiculos = new ArrayList<>();
        for (Alocacao alocacao : alocacoes) {
            veiculos.add(validateVeiculo(alocacao.getPlaca()));
        }
        return veiculos;
    }

    private Veiculo validateVeiculo(String placa) {
        var veiculo = veiculoService.findByPlaca(placa);
        if (veiculo.isPresent()) {
            return veiculo.get();
        }
        throw new VeiculoNotFoundException(placa);
    }

    private Integer countCarros(List<Veiculo> veiculos) {
        return veiculos.stream().filter(veiculo -> veiculo.getTipoVeiculo() == TipoVeiculoEnum.CARRO).toList().size();
    }

    private Integer countMotos(List<Veiculo> veiculos) {
        return veiculos.stream().filter(veiculo -> veiculo.getTipoVeiculo() == TipoVeiculoEnum.MOTO).toList().size();
    }

    private AlocacaoResponseDTO calculateParkingPrice(Alocacao alocacao) {
        var parquimetroInfos = parquimetroService.findInfos().get(0);
        var response = mapper.of(alocacao);
        response.setHorasAlocado(getParkingTime(alocacao));
        response.setPrecoAPagar(String.format("R$ %s", getFinalPrice(response.getHorasAlocado(), parquimetroInfos)));
        return response;
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
}
