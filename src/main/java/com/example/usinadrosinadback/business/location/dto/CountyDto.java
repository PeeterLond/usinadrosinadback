package com.example.usinadrosinadback.business.location.dto;

import com.example.usinadrosinadback.domain.location.county.County;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyDto implements Serializable {
    private Integer countyId;
    private String countyName;
}