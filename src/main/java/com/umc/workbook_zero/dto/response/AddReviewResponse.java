package com.umc.workbook_zero.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddReviewResponse {
    private Long reviewId;
    private String message;
}