package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisement.tool.Tool;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Tool}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolDto implements Serializable {
    private Integer toolId;
    @NotNull
    @Size(max = 50)
    private String toolName;
}