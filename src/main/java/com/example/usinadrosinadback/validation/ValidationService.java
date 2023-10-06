package com.example.usinadrosinadback.validation;

import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.infrastucture.exception.BusinessException;

import java.util.Optional;

import static com.example.usinadrosinadback.validation.Error.*;

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

    public static Contact getValidContact(Optional<Contact> contact) {
        if (contact.isEmpty()) {
            throw new BusinessException(USER_DOESNT_EXIST.getMessage(), USER_DOESNT_EXIST.getErrorCode());
        }
        return contact.get();
    }


}
