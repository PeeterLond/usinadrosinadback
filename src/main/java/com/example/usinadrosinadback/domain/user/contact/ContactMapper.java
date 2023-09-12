package com.example.usinadrosinadback.domain.user.contact;

import com.example.usinadrosinadback.business.user.contact.dto.ContactDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.image.Image;
import com.example.usinadrosinadback.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {


    @Mapping(source = "contactIntroduction", target = "introduction")
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactMobileNumber", target = "mobileNumber")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactFirstName", target = "firstName")
    Contact toContact(ContactDto contactDto);



    @Mapping(source = "firstName",target = "contactFirstName")
    @Mapping(source = "lastName",target = "contactLastName")
    @Mapping(source = "mobileNumber",target = "contactMobileNumber")
    @Mapping(source = "email",target = "contactEmail")
    @Mapping(source = "county.id",target = "countyId")
    @Mapping(source = "city.id",target = "cityId")
    @Mapping(source = "user.password",target = "userPassword")
    @Mapping(source = "introduction",target = "contactIntroduction")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "user.username",target = "userUsername")
    ContactDto toContactInfoDto(Contact contact);


    @Named("imageToImageData")
    static String imageToImageData(Image image){
        return ImageConverter.imageToImageData(image);
    }

}