package com.example.usinadrosinadback.business.login;

import com.example.usinadrosinadback.business.login.dto.LoginResponseDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserMapper;
import com.example.usinadrosinadback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponseDto login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        return userMapper.toLoginResponseDto(user);
    }
}
