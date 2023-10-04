package com.example.usinadrosinadback.business.advertisement.adwithcontact;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementContactShowDto;
import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementMapper;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementService;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.domain.user.contact.ContactService;
import com.example.usinadrosinadback.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdWithContactService {

    @Resource
    private AdvertisementService advertisementService;

    @Resource
    private ContactService contactService;

    @Resource
    private AdvertisementMapper advertisementMapper;

    public List<AdvertisementContactShowDto> getAllAdvertisementsWithContact() {
        List<Advertisement> allAdvertisements = advertisementService.getAllAdvertisements();
        return getAndSetContactsToAdvertisementDtos(allAdvertisements);
    }

    public List<AdvertisementContactShowDto> getUserAdvertisementsWithContactBy(Integer userId) {
        List<Advertisement> userAdvertisements = advertisementService.getUserAdvertisementBy(userId);
        return getAndSetContactsToAdvertisementDtos(userAdvertisements);
    }

    private List<AdvertisementContactShowDto> getAndSetContactsToAdvertisementDtos(List<Advertisement> advertisements) {
        List<AdvertisementContactShowDto> advertisementDtos = advertisementMapper.toAdvertisementContactShowDtos(advertisements);
        ArrayList<Contact> contacts = contactService.getAdvertisementsContactInfo(advertisementDtos);
        setContactInfoToAdvertisement(advertisementDtos, contacts);
        return advertisementDtos;
    }

    private static void setContactInfoToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts) {
        for (int i = 0; i < advertisementDtos.size(); i++) {
            advertisementDtos.get(i).setContactFirstName(contacts.get(i).getFirstName());
            advertisementDtos.get(i).setContactLastName(contacts.get(i).getLastName());
            advertisementDtos.get(i).setContactCountyName(contacts.get(i).getCounty().getName());
            validateAndSetContactCityToAdvertisement(advertisementDtos, contacts, i);
            validateAndSetContactImageToAdvertisement(advertisementDtos, contacts, i);
            validateAndSetContactMobileToAdvertisement(advertisementDtos, contacts, i);
            advertisementDtos.get(i).setContactEmail(contacts.get(i).getEmail());
        }
    }

    private static void validateAndSetContactMobileToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getMobileNumber() != null) {
            advertisementDtos.get(i).setContactMobileNumber(contacts.get(i).getMobileNumber());
        }
    }

    private static void validateAndSetContactImageToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getImage() != null) {
            String image = ImageConverter.imageToImageData(contacts.get(i).getImage());
            advertisementDtos.get(i).setContactImageData(image);
        }
    }

    private static void validateAndSetContactCityToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getCity() != null) {
            advertisementDtos.get(i).setContactCityName(contacts.get(i).getCity().getName());
        }
    }

    public List<AdvertisementContactShowDto> getAdvertisementsWithContactBy(Integer countyId, Integer cityId,
                                                                            Integer toolId, Integer typeId) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsBy(countyId, cityId, toolId, typeId);
        return getAndSetContactsToAdvertisementDtos(advertisements);
    }
}
