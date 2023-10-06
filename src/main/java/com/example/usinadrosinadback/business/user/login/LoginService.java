package com.example.usinadrosinadback.business.user.login;

import com.example.usinadrosinadback.business.user.login.dto.LoginResponseDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserMapper;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.domain.user.contact.ContactService;
import com.example.usinadrosinadback.util.PasswordGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;

    @Resource
    private UserMapper userMapper;

    public LoginResponseDto login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        return userMapper.toLoginResponseDto(user);
    }

    public void resetPassword(String email) {
        Contact contact = contactService.checkUserExists(email);
        User user = userService.getUserBy(contact.getUser().getId());

        String newPassword = PasswordGenerator.newRandomPassword();
        user.setPassword(newPassword);
        userService.saveUser(user);


        // send password to email
    }
}
