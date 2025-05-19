package com.umc.workbook_zero.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyReviewResponse {
    private Long reviewId;
    private String title;
    private String body;
    private Float score;
    private String storeName;
    private LocalDateTime createdAt;
}