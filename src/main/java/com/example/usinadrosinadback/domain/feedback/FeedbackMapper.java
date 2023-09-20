package com.example.usinadrosinadback.domain.feedback;

import com.example.usinadrosinadback.business.user.feedback.dto.FeedbackDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeedbackMapper {

    @Mapping(source = "feedbackComment", target = "comment")
    @Mapping(source = "feedbackRating", target = "rating")
    Feedback toFeedback(FeedbackDto request);

    @Mapping(source = "comment", target = "feedbackComment")
    @Mapping(source = "rating", target = "feedbackRating")
    @Mapping(source = "receiverUser.id", target = "receiverUserId")
    FeedbackDto toFeedbackDto(Feedback feedback);

    List<FeedbackDto> toFeedbackDtos(List<Feedback> feedbacks);

}