package com.tech.challenge.parking.meter.api.exceptions;

public class EletrodomesticoNotFound extends NotFoundException {

    public EletrodomesticoNotFound(Long id) {
        super(String.format("Eletrodomestico ID [%d] not found", id));
    }
}
