package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.apiPayload.ApiResponse;
import com.umc.workbook_zero.dto.request.ChallengeMissionRequest;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;
import com.umc.workbook_zero.service.MissionService.MissionCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<ChallengeMissionResponse> challengeMission(
            @Valid @RequestBody ChallengeMissionRequest request
    ) {
        ChallengeMissionResponse response = missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(response);
    }
}

