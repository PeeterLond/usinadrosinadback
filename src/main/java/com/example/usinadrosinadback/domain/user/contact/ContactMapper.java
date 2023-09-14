package com.example.usinadrosinadback.domain.user.contact;

import com.example.usinadrosinadback.business.user.contact.dto.ContactCreateAndEditDto;
import com.example.usinadrosinadback.business.user.contact.dto.ContactShowInfoDto;
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
    Contact toContact(ContactCreateAndEditDto contactCreateAndEditDto);

    @Mapping(source = "firstName", target = "contactFirstName")
    @Mapping(source = "lastName", target = "contactLastName")
    @Mapping(source = "mobileNumber", target = "contactMobileNumber")
    @Mapping(source = "email", target = "contactEmail")
    @Mapping(source = "county.id", target = "countyId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "user.password", target = "userPassword")
    @Mapping(source = "introduction", target = "contactIntroduction")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "user.username", target = "userUsername")
    ContactCreateAndEditDto toCreateAndEditContactInfoDto(Contact contact);

    @Mapping(source = "user.username", target = "userUsername")
    @Mapping(source = "firstName", target = "contactFirstName")
    @Mapping(source = "lastName", target = "contactLastName")
    @Mapping(source = "county.name", target = "countyName")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "mobileNumber", target = "contactMobileNumber")
    @Mapping(source = "email", target = "contactEmail")
    @Mapping(source = "introduction", target = "contactIntroduction")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    ContactShowInfoDto toShowContactInfoDto(Contact contact);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactIntroduction", target = "introduction")
    @Mapping(source = "contactFirstName", target = "firstName")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactMobileNumber", target = "mobileNumber")
    Contact partialUpdate(ContactCreateAndEditDto contactCreateAndEditDto, @MappingTarget Contact contact);


    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        return ImageConverter.imageToImageData(image);
    }
}