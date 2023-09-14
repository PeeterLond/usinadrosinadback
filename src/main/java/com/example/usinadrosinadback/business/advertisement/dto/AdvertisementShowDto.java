package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Advertisement}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementShowDto implements Serializable {
    private Integer advertisementId;
    private Integer userId;
    private String countyName;
    private String cityName;
    private String toolName;
    private String typeName;
    private Integer coordinateId;
    private BigDecimal coordinateLongField;
    private BigDecimal coordinateLat;
    @NotNull
    @Size(max = 2000)
    private String advertisementDescription;
    private Integer advertisementArea;
    @NotNull
    private BigDecimal advertisementPrice;
    @NotNull
    private Instant advertisementTime;
}