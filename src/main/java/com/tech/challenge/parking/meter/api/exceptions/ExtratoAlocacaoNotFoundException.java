package com.tech.challenge.parking.meter.api.exceptions;

public class ExtratoAlocacaoNotFoundException  extends NotFoundException {

    public ExtratoAlocacaoNotFoundException(String placa) {
        super(String.format("Extrato Alocacao not found for sent Placa %s ", placa));
    }
}
