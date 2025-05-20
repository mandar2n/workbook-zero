package com.umc.workbook_zero.service.MissionService;

import com.umc.workbook_zero.dto.response.ChallengingMissionResponse;
import com.umc.workbook_zero.dto.response.StoreMissionResponse;
import com.umc.workbook_zero.dto.response.StoreMissionSliceResponse;

import java.util.List;

public interface MissionQueryService {
    List<ChallengingMissionResponse> getMyChallengingMissions(Long memberId, int page);
    List<StoreMissionResponse> getMissionsByStoreId(Long storeId, int page);
    StoreMissionSliceResponse getSliceMissionsByStoreId(Long storeId, int page);

}
