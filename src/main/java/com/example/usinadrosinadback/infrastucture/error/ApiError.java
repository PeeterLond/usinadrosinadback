package com.example.usinadrosinadback.infrastucture.error;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}
