package com.umc.workbook_zero.repository.ReviewRepository;

import com.umc.workbook_zero.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {}