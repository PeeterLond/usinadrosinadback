package com.example.usinadrosinadback.business.user.contact.dto;

import com.example.usinadrosinadback.domain.user.contact.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Value
public class ContactDto implements Serializable {
    @NotNull
    String userUsername;
    @NotNull
    String userPassword;
    @NotNull
    Integer countyId;
    Integer cityId;
    String imageData;
    @NotNull
    @Size(max = 50)
    String contactFirstName;
    @NotNull
    @Size(max = 50)
    String contactLastName;
    @Size(max = 50)
    String contactMobileNumber;
    @NotNull
    @Size(max = 50)
    String contactEmail;
    @Size(max = 2000)
    String contactIntroduction;
}