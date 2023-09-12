package com.example.usinadrosinadback.domain.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdvertisementMapper {


    @Mapping(source = "advertisementPrice", target = "price")
    @Mapping(source = "advertisementArea", target = "area")
    @Mapping(source = "advertisementDescription", target = "description")
    Advertisement toAdvertisement(AdvertisementDto advertisementDto);

}