package com.umc.workbook_zero.service.MissionService;

import com.umc.workbook_zero.dto.response.ChallengingMissionResponse;

import java.util.List;

public interface MissionQueryService {
    List<ChallengingMissionResponse> getMyChallengingMissions(Long memberId, int page);
}
