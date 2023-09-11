package com.example.usinadrosinadback.business.user.contact;

import com.example.usinadrosinadback.business.Status;
import com.example.usinadrosinadback.business.user.contact.dto.ContactDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.domain.user.contact.ContactMapper;
import com.example.usinadrosinadback.domain.user.contact.ContactService;
import com.example.usinadrosinadback.domain.user.role.Role;
import com.example.usinadrosinadback.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Resource
    private ContactService contactService;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    public void addContact(ContactDto request) {

        //    @Mapping(source = "imageData", target = "image.data")
//        @Mapping(source = "cityCountyId", target = "city.county.id")
//    @Mapping(source = "cityId", target = "city.id")


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


    }
}
