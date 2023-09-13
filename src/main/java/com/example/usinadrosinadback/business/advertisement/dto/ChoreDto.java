package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisement.chore.Chore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Chore}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoreDto implements Serializable {
    private Integer choreId;
    @NotNull
    @Size(max = 50)
    private String choreName;
}