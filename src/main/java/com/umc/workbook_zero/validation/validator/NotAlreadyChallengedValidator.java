package com.umc.workbook_zero.validation.validator;

import com.umc.workbook_zero.domain.enums.MissionStatus;
import com.umc.workbook_zero.dto.request.ChallengeMissionRequest;
import com.umc.workbook_zero.repository.MemberMissionRepository.MemberMissionRepository;
import com.umc.workbook_zero.validation.annotation.NotAlreadyChallenged;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengedValidator implements ConstraintValidator<NotAlreadyChallenged, ChallengeMissionRequest> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(ChallengeMissionRequest request, ConstraintValidatorContext context) {
        if (request == null || request.getMemberId() == null || request.getMissionId() == null) {
            return true; // 다른 @NotNull에서 검증되므로 여기선 true 반환
        }

        // 해당 회원이 해당 미션을 이미 "CHALLENGING" 상태로 진행 중이라면 false 리턴
        return !memberMissionRepository.existsByMember_MemberIdAndMission_MissionIdAndStatus(
                request.getMemberId(),
                request.getMissionId(),
                MissionStatus.CHALLENGING
        );
    }
}
