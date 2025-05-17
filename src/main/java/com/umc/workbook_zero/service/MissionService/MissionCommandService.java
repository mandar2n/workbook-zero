package com.umc.workbook_zero.service.MissionService;

import com.umc.workbook_zero.dto.request.ChallengeMissionRequest;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;

public interface MissionCommandService {
    ChallengeMissionResponse challengeMission(ChallengeMissionRequest request);
}

