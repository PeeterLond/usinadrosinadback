package com.example.usinadrosinadback.business.user.contact;

import com.example.usinadrosinadback.business.Status;
import com.example.usinadrosinadback.business.user.contact.dto.ContactDto;
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
    public void addContact(ContactDto request) {

        contactService.confirmContactUsernameAvailability(request.getUserUsername());
        Contact contact = contactMapper.toContact(request);
        User user = new User();
        user.setUsername(request.getUserUsername());
        user.setPassword(request.getUserPassword());
        user.setStatus(Status.ACTIVE.getLetter());
        Role customerRole = roleService.getRole();
        user.setRole(customerRole);
        userService.saveUser(user);
        contact.setUser(user);

        County county = countyService.getCountyBy(request.getCountyId());
        contact.setCounty(county);

        City city = cityService.getCityBy(request.getCityId());
        contact.setCity(city);

        String imageData = request.getImageData();

        if (hasImage(imageData)) {
            saveAndSetNewImageToContact(imageData, contact);
        }

        contactService.saveContact(contact);

    }

    private void saveAndSetNewImageToContact(String imageData, Contact contact) {
        Image image = ImageConverter.imageDataToImage(imageData);
        imageService.saveImage(image);
        contact.setImage(image);

    }

    private boolean hasImage(String imageData) {
        return imageData != null && !imageData.isEmpty();
    }
}
