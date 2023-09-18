package com.example.usinadrosinadback.domain.user.contact;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementContactShowDto;
import com.example.usinadrosinadback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void confirmContactUsernameAvailability(String username) {
        boolean contactUsernameExists = contactRepository.contactExistsBy(username);
        ValidationService.validateContactUsernameIsAvailable(contactUsernameExists);
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getAdvertisementContactInfo(Integer userId) {
        return contactRepository.getContactBy(userId);

    }

    public ArrayList<Contact> getAdvertisementsContactInfo(List<AdvertisementContactShowDto> advertisementContactShowDtos) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (AdvertisementContactShowDto advertisementContactShowDto : advertisementContactShowDtos) {
            Contact contact = contactRepository.getContactBy(advertisementContactShowDto.getUserId());
            contacts.add(contact);
        }
        return contacts;
    }
}
