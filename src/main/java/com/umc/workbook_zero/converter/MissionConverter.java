package com.umc.workbook_zero.converter;

import com.umc.workbook_zero.domain.Member;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.domain.Store;
import com.umc.workbook_zero.domain.enums.MissionStatus;
import com.umc.workbook_zero.domain.mapping.MemberMission;
import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;
import com.umc.workbook_zero.dto.response.ChallengingMissionResponse;
import com.umc.workbook_zero.dto.response.StoreMissionResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionConverter {

    public ChallengeMissionResponse toChallengeMissionResponse(MemberMission memberMission) {
        return new ChallengeMissionResponse(
                memberMission.getMember().getMemberId(),
                memberMission.getMission().getMissionId(),
                memberMission.getStatus()
        );
    }

    public MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public Mission toEntity(AddMissionRequest request, Store store) {
        return Mission.builder()
                .store(store)
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public List<ChallengingMissionResponse> toChallengingMissionResponseList(List<Mission> missions) {
        return missions.stream()
                .map(m -> ChallengingMissionResponse.builder()
                        .missionId(m.getMissionId())
                        .storeName(m.getStore().getName())
                        .missionSpec(m.getMissionSpec())
                        .reward(m.getReward())
                        .deadline(m.getDeadline())
                        .build())
                .collect(Collectors.toList());
    }

    public List<StoreMissionResponse> toStoreMissionResponseList(List<Mission> missions) {
        return missions.stream()
                .map(mission -> StoreMissionResponse.builder()
                        .missionId(mission.getMissionId())
                        .reward(mission.getReward())
                        .deadline(mission.getDeadline())
                        .missionSpec(mission.getMissionSpec())
                        .build())
                .collect(Collectors.toList());
    }
}
