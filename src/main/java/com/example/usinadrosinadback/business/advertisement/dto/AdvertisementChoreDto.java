package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisementchore.AdvertisementChore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link AdvertisementChore}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementChoreDto implements Serializable {
    private Integer choreId;
    private Integer advertisementId;
}