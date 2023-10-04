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
public class AdvertisementContactShowDto implements Serializable {
    private Integer advertisementId;
    private Integer userId;
    private String userName;
    private Float user_avg_rating;
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
    private Float advertisementPrice;
    @NotNull
    private Instant advertisementTime;
    @NotNull
    @Size(max = 50)
    private String contactFirstName;
    @NotNull
    @Size(max = 50)
    private String contactLastName;
    @NotNull
    private String contactCountyName;
    private String contactCityName;
    private String contactImageData;
    @Size(max = 50)
    private String contactMobileNumber;
    @NotNull
    @Size(max = 50)
    private String contactEmail;

}