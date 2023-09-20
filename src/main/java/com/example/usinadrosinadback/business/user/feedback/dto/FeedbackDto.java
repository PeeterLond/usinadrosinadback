package com.example.usinadrosinadback.business.user.feedback.dto;

import com.example.usinadrosinadback.domain.feedback.Feedback;
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

    private Integer receiverUserId;
    @NotNull
    private Integer feedbackRating;
    @Size(max = 2000)
    private String feedbackComment;
}