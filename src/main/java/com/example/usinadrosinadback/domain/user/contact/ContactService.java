package com.example.usinadrosinadback.domain.user.contact;

import com.example.usinadrosinadback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void confirmContactUsernameAvailability(String username) {
        boolean contactUsernameExists = contactRepository.contactExistsBy(username);
        ValidationService.validateContactUsernameIsAvailable(contactUsernameExists);
    }
}
