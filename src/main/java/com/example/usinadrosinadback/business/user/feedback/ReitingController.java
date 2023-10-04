package com.example.usinadrosinadback.business.user.feedback;

import com.example.usinadrosinadback.business.user.feedback.dto.FeedbackDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReitingController {

    @Resource
    private ReitingService reitingService;

    @GetMapping("/feedback")
    @Operation(summary = "Tagastab kõik kasutajale antud tagasisided receiver userId järgi")
    public List<FeedbackDto> findUserFeedbacks(@RequestParam Integer userId) {
        return reitingService.findUserFeedbacks(userId);
    }

    @PostMapping("/feedback")
    @Operation(summary="Loob kasutajale uue tagasiside ja muudab kasutaja keskmise reitngu väärtuse.")
    public void addFeedback(@RequestBody FeedbackDto request) {
        reitingService.addFeedbackAndChangeAvgRating(request);
    }
 }
