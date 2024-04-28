package com.ada.economizaapi.exceptions;

public class EntidadeJaExisteException extends RuntimeException {

    public EntidadeJaExisteException() {
    }

    public EntidadeJaExisteException(String message) {
        super(message);
    }
}
