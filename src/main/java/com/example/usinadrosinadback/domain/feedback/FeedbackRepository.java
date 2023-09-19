package com.example.usinadrosinadback.domain.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("select f from Feedback f where f.receiverUser.id = ?1")
    List<Feedback> findFeedbacksBy(Integer id);
}