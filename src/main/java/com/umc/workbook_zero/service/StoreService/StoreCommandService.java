package com.umc.workbook_zero.service.StoreService;

import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;
import com.umc.workbook_zero.dto.response.AddReviewResponse;

public interface StoreCommandService {
    AddMissionResponse addMission(Long storeId, AddMissionRequest request);
    AddReviewResponse addReview(Long storeId, AddReviewRequest request);
}
