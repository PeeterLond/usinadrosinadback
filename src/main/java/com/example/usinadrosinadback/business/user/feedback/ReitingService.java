package com.example.usinadrosinadback.business.user.feedback;

import com.example.usinadrosinadback.business.user.feedback.dto.FeedbackDto;
import com.example.usinadrosinadback.domain.feedback.*;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ReitingService {
    @Resource
    private FeedbackService feedbackService;

    @Resource
    private FeedbackMapper feedbackMapper;
    @Resource
    private UserService userService;

    @Transactional
    public void addFeedbackAndChangeAvgRating(FeedbackDto request) {
        Feedback feedback = feedbackMapper.toFeedback(request);
        getAndSetUser(request, feedback);
        feedbackService.saveFeedback(feedback);
        changeUserAverageRating(request.getReceiverUserId());
    }

    public List<FeedbackDto> findUserFeedbacks(Integer userId) {
        List<Feedback> feedbacks = feedbackService.findUserFeedbacksBy(userId);
        return feedbackMapper.toFeedbackDtos(feedbacks);
    }

    private void changeUserAverageRating(Integer userId) {
        User user = userService.getUserBy(userId);
        List<Feedback> feedbacks = feedbackService.findUserFeedbacksBy(userId);

        float ratingAvg = calculateAverageRating(feedbacks);

        user.setAvgRating(ratingAvg);
        userService.saveUser(user);

    }

    private void getAndSetUser(FeedbackDto request, Feedback feedback) {
        User user = userService.getUserBy(request.getReceiverUserId());
        feedback.setReceiverUser(user);
    }

    private static float calculateAverageRating(List<Feedback> feedbacks) {
        int ratingSum = 0;
        int nrOfFeedbacks = 0;
        for (Feedback feedback : feedbacks) {
            ratingSum += feedback.getRating();
            nrOfFeedbacks++;
        }
        return new BigDecimal(ratingSum).divide(new BigDecimal(nrOfFeedbacks),
                1, RoundingMode.HALF_UP).floatValue();
    }

}
