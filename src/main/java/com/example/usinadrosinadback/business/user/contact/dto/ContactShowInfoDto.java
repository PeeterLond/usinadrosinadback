package com.example.usinadrosinadback.business.user.contact.dto;

import com.example.usinadrosinadback.domain.user.contact.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactShowInfoDto implements Serializable {
    @NotNull
    private String userUsername;
    @NotNull
    private String countyName;
    private String cityName;
    private String imageData;
    @NotNull
    @Size(max = 50)
    private String contactFirstName;
    @NotNull
    @Size(max = 50)
    private String contactLastName;
    @Size(max = 50)
    private String contactMobileNumber;
    @NotNull
    @Size(max = 50)
    private String contactEmail;
    @Size(max = 2000)
    private String contactIntroduction;
}