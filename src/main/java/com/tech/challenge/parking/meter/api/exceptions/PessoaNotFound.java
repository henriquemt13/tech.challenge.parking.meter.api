package com.tech.challenge.parking.meter.api.exceptions;

public class PessoaNotFound extends NotFoundException {

    public PessoaNotFound(Long userId) {
        super(String.format("Pessoa ID [%d] not found", userId));
    }
}
