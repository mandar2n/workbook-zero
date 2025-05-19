package com.umc.workbook_zero.service.ReviewService;

import com.umc.workbook_zero.dto.response.MyReviewResponse;

import java.util.List;

public interface ReviewQueryService {
    List<MyReviewResponse> getMyReviews(Long memberId, int page);
}
