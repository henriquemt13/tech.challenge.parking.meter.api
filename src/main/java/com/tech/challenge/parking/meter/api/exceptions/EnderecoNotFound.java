package com.tech.challenge.parking.meter.api.exceptions;

public class EnderecoNotFound extends NotFoundException {

    public EnderecoNotFound(Long id) {
        super(String.format("Endereco ID [%d] not found", id));
    }
}
