package com.hati.service;

import com.hati.domain.Feedback;
import com.hati.dto.FeedbackRequest;
import com.hati.dto.FeedbackResponse;
import com.hati.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public FeedbackResponse createFeedback(FeedbackRequest request) {
        Feedback feedback = new Feedback();
        feedback.setContent(request.getFeedback());
        feedback.setEmail(request.getEmail());

        Feedback savedFeedback = feedbackRepository.save(feedback);

        return new FeedbackResponse(
                savedFeedback.getId(),
                savedFeedback.getContent(),
                savedFeedback.getEmail(),
                savedFeedback.getCreatedAt()
        );
    }
}