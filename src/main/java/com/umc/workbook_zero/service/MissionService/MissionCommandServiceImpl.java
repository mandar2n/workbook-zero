package com.umc.workbook_zero.service.MissionService;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.MemberException;
import com.umc.workbook_zero.apiPayload.exception.MissionException;
import com.umc.workbook_zero.converter.MissionConverter;
import com.umc.workbook_zero.domain.Member;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.domain.mapping.MemberMission;
import com.umc.workbook_zero.dto.request.ChallengeMissionRequest;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;
import com.umc.workbook_zero.repository.MemberMissionRepository.MemberMissionRepository;
import com.umc.workbook_zero.repository.MemberRepository.MemberRepository;
import com.umc.workbook_zero.repository.MissionRepository.MissionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionConverter missionConverter;

    @Override
    public ChallengeMissionResponse challengeMission(@Valid ChallengeMissionRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberException(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionException(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = missionConverter.toMemberMission(member, mission);

        memberMissionRepository.save(memberMission);
        return missionConverter.toChallengeMissionResponse(memberMission);
    }

}
