package com.example.usinadrosinadback.domain.location.city;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Value
public class CityDto implements Serializable {
    Integer cityId;
    Integer countyId;
    @Size(max = 50)
    String cityName;
}