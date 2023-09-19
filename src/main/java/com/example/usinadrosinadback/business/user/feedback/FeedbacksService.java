package com.example.usinadrosinadback.business.user.feedback;

import com.example.usinadrosinadback.business.user.feedback.dto.FeedbackDto;
import com.example.usinadrosinadback.domain.feedback.Feedback;
import com.example.usinadrosinadback.domain.feedback.FeedbackMapper;
import com.example.usinadrosinadback.domain.feedback.FeedbackService;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbacksService {
    @Resource
    private FeedbackService feedbackService;

    @Resource
    private FeedbackMapper feedbackMapper;
    @Resource
    private UserService userService;

    @Transactional
    public void addFeedback(FeedbackDto request) {
        Feedback feedback = feedbackMapper.toFeedback(request);
        User user = userService.getUserBy(request.getReceiverUserId());
        feedback.setReceiverUser(user);
        feedback.setComment(request.getFeedbackComment());
        feedback.setRating(request.getFeedbackRating());
        feedbackService.saveFeedback(feedback);

    }

    public List<FeedbackDto> findUserFeedbacks(Integer userId) {
        List<Feedback> feedbacks = feedbackService.findUserFeedbacksBy(userId);
        List<FeedbackDto> feedbackDtos = feedbackMapper.toFeedbackDtos(feedbacks);
        return feedbackDtos;

    }
}
