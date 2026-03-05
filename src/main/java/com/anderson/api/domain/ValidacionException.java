package com.anderson.api.domain;

public class ValidacionException extends RuntimeException {
    //Esta excepcion devuelve el resultado que se ponga en el codigo
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
