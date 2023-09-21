package com.example.usinadrosinadback.domain.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementContactShowDto;
import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdvertisementMapper {


    @Mapping(source = "advertisementPrice", target = "price")
    @Mapping(source = "advertisementArea", target = "area")
    @Mapping(source = "advertisementDescription", target = "description")
    Advertisement toAdvertisement(AdvertisementDto advertisementDto);



    @Mapping(source = "id", target = "advertisementId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "county.name", target = "countyName")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "tool.name", target = "toolName")
    @Mapping(source = "type.name", target = "typeName")
    @Mapping(source = "coordinate.id", target = "coordinateId")
    @Mapping(source = "coordinate.longField", target = "coordinateLongField")
    @Mapping(source = "coordinate.lat", target = "coordinateLat")
    @Mapping(source = "description", target = "advertisementDescription")
    @Mapping(source = "area", target = "advertisementArea")
    @Mapping(source = "price", target = "advertisementPrice")
    @Mapping(source = "time", target = "advertisementTime")
    AdvertisementContactShowDto toAdvertisementContactShowDto(Advertisement advertisement);


    List<AdvertisementContactShowDto> toAdvertisementContactShowDtos(List<Advertisement> advertisements);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "county.id", target = "countyId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "tool.id", target = "toolId")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "coordinate.longField", target = "coordinateLongField")
    @Mapping(source = "coordinate.lat", target = "coordinateLat")
    @Mapping(source = "description", target = "advertisementDescription")
    @Mapping(source = "area", target = "advertisementArea")
    @Mapping(source = "price", target = "advertisementPrice")
    AdvertisementDto toAdvertisementDto(Advertisement advertisement);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "advertisementDescription", target = "description")
    @Mapping(source = "advertisementArea", target = "area")
    @Mapping(source = "advertisementPrice", target = "price")
    Advertisement partialUpdate(AdvertisementDto request, @MappingTarget Advertisement advertisement);

}