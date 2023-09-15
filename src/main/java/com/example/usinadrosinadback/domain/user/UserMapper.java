package com.example.usinadrosinadback.domain.user;

import com.example.usinadrosinadback.business.user.login.dto.LoginResponseDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponseDto toLoginResponseDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "userPassword", target = "password")
    User passwordUpdate(UserUpdatePasswordDto userUpdatePasswordDto, @MappingTarget User user);
}