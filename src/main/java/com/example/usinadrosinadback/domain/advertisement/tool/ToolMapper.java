package com.example.usinadrosinadback.domain.advertisement.tool;

import com.example.usinadrosinadback.business.advertisement.dto.ToolDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ToolMapper {

    @Mapping(source = "id", target = "toolId")
    @Mapping(source = "name", target = "toolName")
    ToolDto toToolDto(Tool tool);

    List<ToolDto> toToolDtos(List<Tool> tools);
}