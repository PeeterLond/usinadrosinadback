package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisement.type.Type;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Type}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto implements Serializable {
    private Integer typeId;
    @NotNull
    @Size(max = 50)
    private String typeName;
}