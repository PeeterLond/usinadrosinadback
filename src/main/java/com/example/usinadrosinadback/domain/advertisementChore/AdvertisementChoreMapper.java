package com.example.usinadrosinadback.domain.advertisementChore;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementChoreShowDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdvertisementChoreMapper {


    @Mapping(source = "id", target = "adChoreId")
    @Mapping(source = "chore.name", target = "choreName")
    AdvertisementChoreShowDto toArvertisementChoreDto(AdvertisementChore advertisementChore);

    List<AdvertisementChoreShowDto> toArvertisementChoreDtos(List<AdvertisementChore> advertisementChores);

}