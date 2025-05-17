package com.umc.workbook_zero.service.StoreService;

import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;

public interface StoreCommandService {
    AddMissionResponse addMission(Long storeId, AddMissionRequest request);
}
