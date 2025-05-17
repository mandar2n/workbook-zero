package com.umc.workbook_zero.converter;

import com.umc.workbook_zero.domain.mapping.MemberMission;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public ChallengeMissionResponse toChallengeMissionResponse(MemberMission memberMission) {
        return new ChallengeMissionResponse(
                memberMission.getMember().getMemberId(),
                memberMission.getMission().getMissionId(),
                memberMission.getStatus()
        );
    }
}
