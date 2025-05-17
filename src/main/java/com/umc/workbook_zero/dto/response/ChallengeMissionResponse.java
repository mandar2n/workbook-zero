package com.umc.workbook_zero.dto.response;

import com.umc.workbook_zero.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChallengeMissionResponse {
    private Long memberId;
    private Long missionId;
    private MissionStatus status;
}