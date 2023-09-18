package com.example.usinadrosinadback.business.advertisement.dto;

import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChore;
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
public class AdvertisementChoreShowDto implements Serializable {
    private Integer adChoreId;
    private String choreName;
}