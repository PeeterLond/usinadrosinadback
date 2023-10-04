package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Advertisement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto implements Serializable {
    private Integer userId;
    private Integer countyId;
    private Integer cityId;
    private Integer toolId;
    private Integer typeId;
    private BigDecimal coordinateLongField;
    private BigDecimal coordinateLat;
    @NotNull
    @Size(max = 2000)
    private String advertisementDescription;
    private Integer advertisementArea;
    @NotNull
    private Float advertisementPrice;
}