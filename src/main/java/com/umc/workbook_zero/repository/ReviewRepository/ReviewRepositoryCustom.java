package com.umc.workbook_zero.repository.ReviewRepository;

import com.umc.workbook_zero.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {
    Page<Review> findByMember_MemberId(Long memberId, Pageable pageable);
}
