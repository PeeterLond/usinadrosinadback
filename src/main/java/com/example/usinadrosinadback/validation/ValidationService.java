package com.example.usinadrosinadback.validation;

import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.infrastucture.exception.BusinessException;

import java.util.Optional;

public class ValidationService {

    public static User getValidUser(Optional<User> user) {
        if (user.isEmpty()){
            throw new BusinessException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode());
        }
        return user.get();
    }
}
