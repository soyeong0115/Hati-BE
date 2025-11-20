package com.hati.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FeedbackResponse {
    private Long id;
    private String content;
    private String email;
    private LocalDateTime createdAt;
}
