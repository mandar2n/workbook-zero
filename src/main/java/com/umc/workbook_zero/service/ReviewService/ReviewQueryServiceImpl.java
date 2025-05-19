package com.umc.workbook_zero.service.ReviewService;

import com.umc.workbook_zero.converter.ReviewConverter;
import com.umc.workbook_zero.domain.Review;
import com.umc.workbook_zero.dto.response.MyReviewResponse;
import com.umc.workbook_zero.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    public List<MyReviewResponse> getMyReviews(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Review> reviews = reviewRepository.findByMember_MemberId(memberId, pageable);
        return reviews.stream()
                .map(reviewConverter::toMyReviewResponse)
                .collect(Collectors.toList());
    }
}