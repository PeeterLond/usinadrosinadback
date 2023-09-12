package com.example.usinadrosinadback.business.location.dto;

import com.example.usinadrosinadback.domain.location.city.City;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {
    private Integer cityId;
    private Integer countyId;
    @Size(max = 50)
    private String cityName;
}