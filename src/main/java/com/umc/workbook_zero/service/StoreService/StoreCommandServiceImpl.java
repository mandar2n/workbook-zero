package com.umc.workbook_zero.service.StoreService;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.MemberException;
import com.umc.workbook_zero.apiPayload.exception.StoreException;
import com.umc.workbook_zero.converter.MissionConverter;
import com.umc.workbook_zero.converter.ReviewConverter;
import com.umc.workbook_zero.domain.Member;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.domain.Review;
import com.umc.workbook_zero.domain.Store;
import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;
import com.umc.workbook_zero.dto.response.AddReviewResponse;
import com.umc.workbook_zero.repository.MemberRepository.MemberRepository;
import com.umc.workbook_zero.repository.MissionRepository.MissionRepository;
import com.umc.workbook_zero.repository.ReviewRepository.ReviewRepository;
import com.umc.workbook_zero.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionConverter missionConverter;
    private final ReviewConverter reviewConverter;

    @Override
    public AddMissionResponse addMission(Long storeId, AddMissionRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = missionConverter.toEntity(request, store);
        Mission savedMission = missionRepository.save(mission);

        return new AddMissionResponse(savedMission.getMissionId(), "미션이 성공적으로 추가되었습니다.");
    }

    @Override
    public AddReviewResponse addReview(Long storeId, AddReviewRequest request) {
        // 유효성 검증은 @ExistsStore 어노테이션에서 처리됨
        Store store = storeRepository.getReferenceById(storeId);

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberException(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = reviewConverter.toEntity(request, store, member);
        Review saved = reviewRepository.save(review);

        return new AddReviewResponse(saved.getReviewId(), "리뷰가 성공적으로 등록되었습니다.");
    }
}