package com.umc.workbook_zero.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.workbook_zero.domain.QReview;
import com.umc.workbook_zero.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    QReview review = QReview.review;

    @Override
    public Page<Review> findByMember_MemberId(Long memberId, Pageable pageable) {
        // 리스트 조회
        List<Review> results = jpaQueryFactory
                .selectFrom(review)
                .where(review.member.memberId.eq(memberId))
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 전체 개수 조회
        long total = jpaQueryFactory
                .select(review.count())
                .from(review)
                .where(review.member.memberId.eq(memberId))
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }
}