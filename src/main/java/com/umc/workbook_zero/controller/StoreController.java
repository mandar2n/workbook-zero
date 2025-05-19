package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.apiPayload.ApiResponse;
import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.request.AddReviewRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;
import com.umc.workbook_zero.dto.response.AddReviewResponse;
import com.umc.workbook_zero.service.StoreService.StoreCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/mission")
    @Operation(summary = "가게에 미션 추가하기 API", description = "가게에 미션을 추가합니다.")
    public ApiResponse<AddMissionResponse> addMission(
            @PathVariable Long storeId,
            @Valid @RequestBody AddMissionRequest request
    ) {
        AddMissionResponse response = storeCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(response);
    }

    @PostMapping("/review")
    @Operation(summary = "가게에 리뷰 추가하기 API", description = "가게에 리뷰를 추가합니다.")
    public ApiResponse<AddReviewResponse> addReview(
            @Valid @RequestBody AddReviewRequest request) {
        AddReviewResponse response = storeCommandService.addReview(request);
        return ApiResponse.onSuccess(response);
    }
}
