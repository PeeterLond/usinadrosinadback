package com.example.usinadrosinadback.business.user.contact;

import com.example.usinadrosinadback.business.Status;
import com.example.usinadrosinadback.business.user.contact.dto.ContactCreateAndEditDto;
import com.example.usinadrosinadback.business.user.contact.dto.ContactShowInfoDto;
import com.example.usinadrosinadback.domain.location.city.City;
import com.example.usinadrosinadback.domain.location.city.CityService;
import com.example.usinadrosinadback.domain.location.county.County;
import com.example.usinadrosinadback.domain.location.county.CountyService;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.domain.user.contact.ContactMapper;
import com.example.usinadrosinadback.domain.user.contact.ContactService;
import com.example.usinadrosinadback.domain.user.image.Image;
import com.example.usinadrosinadback.domain.user.image.ImageService;
import com.example.usinadrosinadback.domain.user.role.Role;
import com.example.usinadrosinadback.domain.user.role.RoleService;
import com.example.usinadrosinadback.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class ProfileService {

    @Resource
    private ImageService imageService;

    @Resource
    private CityService cityService;

    @Resource
    private CountyService countyService;

    @Resource
    private ContactService contactService;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private ContactMapper contactMapper;


    @Transactional
    public void addContact(ContactCreateAndEditDto request) {
        contactService.confirmContactUsernameAvailability(request.getUserUsername());
        Contact contact = contactMapper.toContact(request);

        createSaveAndSetUserToContact(request, contact);
        setCountyToContact(request, contact);
        if (hasCityId(request.getCityId())) {
            setCityToContact(request, contact);
        }

        String imageData = request.getImageData();
        if (hasImage(imageData)) {
            saveAndSetNewImageToContact(imageData, contact);
        }

        contactService.saveContact(contact);
    }

    public ContactCreateAndEditDto getContactInfoForEdit(Integer userId) {
        Contact contact = contactService.getContactInfoBy(userId);
        return contactMapper.toCreateAndEditContactInfoDto(contact);

    }
    public ContactShowInfoDto getContactInfoForShow(Integer userId) {
        Contact contact = contactService.getContactInfoBy(userId);
        return contactMapper.toShowContactInfoDto(contact);
    }

    @Transactional
    public void updateContactInfo(Integer userId, ContactCreateAndEditDto request) {
        Contact contact = contactService.getContactInfoBy(userId);
        contactMapper.partialUpdate(request, contact);

        handleCountyUpdate(request, contact);
        handleCityUpdate(request, contact);
        handleImageUpdate(request, contact);

        contactService.saveContact(contact);

        }

    private void handleCityUpdate(ContactCreateAndEditDto request, Contact contact) {
        Integer requestCityId = request.getCityId();
        if (!haveSameCityId(requestCityId, contact)) {
            City city = cityService.getCityBy(requestCityId);
            contact.setCity(city);
        }
    }

    private void handleCountyUpdate(ContactCreateAndEditDto request, Contact contact) {
        Integer requestCountyId = request.getCountyId();
        if (!haveSameCountyId(requestCountyId, contact)) {
            County county = countyService.getCountyBy(requestCountyId);
            contact.setCounty(county);
        }
    }

    private void handleImageUpdate(ContactCreateAndEditDto request, Contact contact){
        Image contactImage = contact.getImage();
        String requestImageData = request.getImageData();

        if (requestImageData.isEmpty()) {
            return;
        }

        if (requestHasNewImage(contactImage, requestImageData)) {
            Image image = ImageConverter.imageDataToImage(requestImageData);
            imageService.saveImage(image);
            contact.setImage(image);

        } else if (requestHasNewDifferentImage(contactImage, requestImageData)) {
            byte[] requestImageDataBytes = ImageConverter.getBytesArrayFromImageData(requestImageData);
            contactImage.setData(requestImageDataBytes);
            imageService.saveImage(contactImage);
        }
    }

    private static boolean requestHasNewImage(Image contactImage, String requestImageData) {
        return contactImage == null && !requestImageData.isEmpty();
    }

    private static boolean requestHasNewDifferentImage(Image contactImage, String requestImageData) {
        boolean hasNewImage = contactImage != null && !requestImageData.isEmpty();
        boolean hasDifferentImage = hasDifferentImage(contactImage, requestImageData);
        return hasNewImage && hasDifferentImage;
    }

    private static boolean hasDifferentImage(Image contactImage, String requestImageData) {
        byte[] requestImageDataBytes = ImageConverter.getBytesArrayFromImageData(requestImageData);
        return contactImage.getData().length != requestImageDataBytes.length &&
                !Arrays.equals(requestImageDataBytes, contactImage.getData());
    }


    private static boolean hasCityId(Integer cityId) {
        return !cityId.equals(0);
    }

    private void setCityToContact(ContactCreateAndEditDto request, Contact contact) {
        City city = cityService.getCityBy(request.getCityId());
        contact.setCity(city);
    }

    private void setCountyToContact(ContactCreateAndEditDto request, Contact contact) {
        County county = countyService.getCountyBy(request.getCountyId());
        contact.setCounty(county);
    }

    private void createSaveAndSetUserToContact(ContactCreateAndEditDto request, Contact contact) {
        User user = new User();
        user.setUsername(request.getUserUsername());
        user.setPassword(request.getUserPassword());
        user.setStatus(Status.ACTIVE.getLetter());
        Role customerRole = roleService.getRole();
        user.setRole(customerRole);
        userService.saveUser(user);
        contact.setUser(user);
    }

    private void saveAndSetNewImageToContact(String imageData, Contact contact) {
        Image image = ImageConverter.imageDataToImage(imageData);
        imageService.saveImage(image);
        contact.setImage(image);
    }

    private boolean hasImage(String imageData) {
        return imageData != null && !imageData.isEmpty();
    }

    private static boolean haveSameCityId(Integer requestCityId, Contact contact) {
        return requestCityId.equals(contact.getCity().getId());
    }

    private static boolean haveSameCountyId(Integer requestCountyId, Contact contact) {
        return requestCountyId.equals(contact.getCounty().getId());
    }


}
