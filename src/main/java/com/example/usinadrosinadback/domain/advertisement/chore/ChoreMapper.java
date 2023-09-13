package com.example.usinadrosinadback.domain.advertisement.chore;

import com.example.usinadrosinadback.business.advertisement.dto.ChoreDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChoreMapper {


    @Mapping(source = "id", target = "choreId")
    @Mapping(source = "name", target = "choreName")
    ChoreDto toChoreDto(Chore chore);

    List<ChoreDto> toChoreDtos(List<Chore> chores);


}