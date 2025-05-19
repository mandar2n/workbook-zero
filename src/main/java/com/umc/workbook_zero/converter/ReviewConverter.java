package com.umc.workbook_zero.converter;

import com.umc.workbook_zero.domain.Member;
import com.umc.workbook_zero.domain.Review;
import com.umc.workbook_zero.domain.Store;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import com.umc.workbook_zero.dto.response.MyReviewResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewConverter {
    public Review toEntity(AddReviewRequest request, Store store, Member member) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .store(store)
                .member(member)
                .build();
    }

    public MyReviewResponse toMyReviewResponse(Review review) {
        return MyReviewResponse.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public List<MyReviewResponse> toMyReviewResponseList(List<Review> reviews) {
        return reviews.stream()
                .map(this::toMyReviewResponse)
                .collect(Collectors.toList());
    }
}