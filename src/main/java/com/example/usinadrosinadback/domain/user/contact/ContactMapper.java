package com.example.usinadrosinadback.domain.user.contact;

import com.example.usinadrosinadback.business.user.contact.dto.ContactDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "contactIntroduction", target = "introduction")
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactMobileNumber", target = "mobileNumber")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactFirstName", target = "firstName")
    Contact toContact(ContactDto contactDto);

}