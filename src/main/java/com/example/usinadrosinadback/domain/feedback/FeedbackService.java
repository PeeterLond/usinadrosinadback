package com.example.usinadrosinadback.domain.feedback;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Resource
    private FeedbackRepository feedbackRepository;


    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> findUserFeedbacksBy(Integer userId) {
        return feedbackRepository.findFeedbacksBy(userId);
    }
}
