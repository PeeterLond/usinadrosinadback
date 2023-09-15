package com.example.usinadrosinadback.business.user.mailbox.dto;

import com.example.usinadrosinadback.domain.user.mailbox.Message;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Message}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto implements Serializable {
    @NotNull
    @Size(max = 255)
    private String messageLetterTitle;
    @NotNull
    @Size(max = 2000)
    private String messageLetterBody;
    @NotNull
    private Instant messageLetterTime;
    private String senderUserUsername;
    private String receiverUserUsername;
    @NotNull
    private Boolean isRead = false;
}