package com.example.usinadrosinadback.domain.location.county;

import com.example.usinadrosinadback.business.location.dto.CountyDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {


    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")
    CountyDto toDto(County county);

    List<CountyDto> toCountyDtos(List<County> counties);

}