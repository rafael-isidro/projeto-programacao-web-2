package com.ada.economizaapi.exceptions;

public class EntidadeNaoExisteException extends RuntimeException {

    public EntidadeNaoExisteException() {
    }

    public EntidadeNaoExisteException(String message) {
        super(message);
    }
}
