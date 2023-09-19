package com.example.usinadrosinadback.domain.feedback;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeedbackMapper {

    @Mapping(source = "feedbackComment", target = "comment")
    @Mapping(source = "feedbackRating", target = "rating")
    Feedback toFeedback(FeedbackContactViewDto request);

    @Mapping(source = "id", target = "feedbackId")
    @Mapping(source = "comment", target = "feedbackComment")
    @Mapping(source = "rating", target = "feedbackRating")
    @Mapping(source = "receiverUser.id", target = "receiverUserId")
    FeedbackDto toFeedbackDto(Feedback feedback);

    List<FeedbackDto> toFeedbackDtos(List<Feedback> feedbacks);

}