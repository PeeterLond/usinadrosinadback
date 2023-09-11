package com.example.usinadrosinadback.validation;

import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.infrastucture.exception.BusinessException;

import java.util.Optional;

import static com.example.usinadrosinadback.validation.Error.CONTACT_USERNAME_UNAVAILABLE;
import static com.example.usinadrosinadback.validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static User getValidUser(Optional<User> user) {
        if (user.isEmpty()){
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return user.get();
    }

    public static void validateContactUsernameIsAvailable(boolean contactUsernameExists) {
        if (contactUsernameExists) {
            throw new BusinessException(
                    CONTACT_USERNAME_UNAVAILABLE.getMessage(),
                    CONTACT_USERNAME_UNAVAILABLE.getErrorCode());
        }
    }
}
