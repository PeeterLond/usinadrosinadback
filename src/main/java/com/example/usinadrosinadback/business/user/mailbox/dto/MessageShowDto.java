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
public class MessageShowDto implements Serializable {
    private Integer messageId;
    @NotNull
    @Size(max = 255)
    private String letterTitle;
    @NotNull
    @Size(max = 2000)
    private String letterBody;
    @NotNull
    private Instant letterTime;
    private Integer senderUserId;
    private String senderUserUsername;
    private Integer receiverUserId;
    private String receiverUserUsername;
    @NotNull
    private Boolean isRead = false;
}