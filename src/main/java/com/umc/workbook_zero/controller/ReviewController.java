package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.apiPayload.ApiResponse;
import com.umc.workbook_zero.dto.response.MyReviewResponse;
import com.umc.workbook_zero.service.ReviewService.ReviewQueryService;
import com.umc.workbook_zero.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/my")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰를 10개씩 페이지네이션 처리하여 반환합니다.")
    public ApiResponse<List<MyReviewResponse>> getMyReviews(
            @ValidPage Integer page,
            // @AuthenticationPrincipal Long memberId)
            @RequestHeader("X-MEMBER-ID") Long memberId // 아직 회원가입 없으므로 임시 방식
    ){

        List<MyReviewResponse> responses = reviewQueryService.getMyReviews(memberId, page);
        return ApiResponse.onSuccess(responses);
    }
}

