package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.apiPayload.ApiResponse;
import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;
import com.umc.workbook_zero.dto.response.AddReviewResponse;
import com.umc.workbook_zero.service.StoreService.StoreCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/mission")
    public ApiResponse<AddMissionResponse> addMission(
            @PathVariable Long storeId,
            @Valid @RequestBody AddMissionRequest request
    ) {
        AddMissionResponse response = storeCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(response);
    }

    @PostMapping("/review")
    public ApiResponse<AddReviewResponse> addReview(
            @Valid @RequestBody AddReviewRequest request) {
        AddReviewResponse response = storeCommandService.addReview(request);
        return ApiResponse.onSuccess(response);
    }
}
