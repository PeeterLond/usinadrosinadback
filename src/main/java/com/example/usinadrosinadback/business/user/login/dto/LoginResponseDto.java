package com.example.usinadrosinadback.business.user.login.dto;

import com.example.usinadrosinadback.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto implements Serializable {
    private Integer userId;
    private String username;
    private String roleName;
}