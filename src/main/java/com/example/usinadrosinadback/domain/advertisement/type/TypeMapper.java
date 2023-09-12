package com.example.usinadrosinadback.domain.advertisement.type;

import com.example.usinadrosinadback.business.advertisement.dto.TypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {


    @Mapping(source = "id", target = "typeId")
    @Mapping(source = "name", target = "typeName")
    TypeDto toTypeDto(Type type);

    List<TypeDto> toTypeDtos(List<Type> types);


}