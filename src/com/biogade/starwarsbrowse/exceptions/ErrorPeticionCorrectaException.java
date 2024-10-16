package com.biogade.starwarsbrowse.exceptions;

public class ErrorPeticionCorrectaException extends RuntimeException {

    private String mensaje;

    public ErrorPeticionCorrectaException(String message) {
        this.mensaje = message;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
