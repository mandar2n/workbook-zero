package com.umc.workbook_zero.converter;

import com.umc.workbook_zero.domain.Member;
import com.umc.workbook_zero.domain.Review;
import com.umc.workbook_zero.domain.Store;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import org.springframework.stereotype.Component;

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
}