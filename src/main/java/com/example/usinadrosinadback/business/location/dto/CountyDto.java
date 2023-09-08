package com.example.usinadrosinadback.business.location.dto;

import com.example.usinadrosinadback.domain.location.county.County;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link County}
 */
@Value
public class CountyDto implements Serializable {
    Integer countyId;
    String countyName;
}