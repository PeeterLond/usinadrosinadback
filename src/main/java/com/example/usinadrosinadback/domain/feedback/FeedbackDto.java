package com.example.usinadrosinadback.domain.feedback;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Feedback}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto implements Serializable {
    @NotNull
    private Integer feedbackId;
    private Integer receiverUserId;
    @NotNull
    private Integer feedbackRating;
    @Size(max = 2000)
    private String feedbackComment;
}