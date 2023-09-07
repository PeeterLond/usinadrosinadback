package com.example.usinadrosinadback.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DELETE("D");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }
}
