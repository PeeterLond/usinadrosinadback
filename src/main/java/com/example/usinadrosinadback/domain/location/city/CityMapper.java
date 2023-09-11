package com.example.usinadrosinadback.domain.location.city;

import com.example.usinadrosinadback.business.location.dto.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {
    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    @Mapping(source = "county.id", target = "countyId")
    CityDto toDto(City city);
    List<CityDto> toCityDtos(List<City> cities);


}
