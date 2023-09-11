package com.example.usinadrosinadback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    CONTACT_USERNAME_UNAVAILABLE("Kasutajanimi on võetud", 222);


    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {

        this.message = message;
        this.errorCode = errorCode;
    }
}

