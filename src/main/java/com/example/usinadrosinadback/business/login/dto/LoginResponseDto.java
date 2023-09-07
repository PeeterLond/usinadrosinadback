package com.example.usinadrosinadback.business.login.dto;

import com.example.usinadrosinadback.domain.user.User;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class LoginResponseDto implements Serializable {
    Integer userId;
    String roleName;
}