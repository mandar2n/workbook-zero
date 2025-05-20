package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.apiPayload.ApiResponse;
import com.umc.workbook_zero.dto.request.ChallengeMissionRequest;
import com.umc.workbook_zero.dto.response.ChallengeMissionResponse;
import com.umc.workbook_zero.dto.response.ChallengingMissionResponse;
import com.umc.workbook_zero.dto.response.StoreMissionResponse;
import com.umc.workbook_zero.service.MissionService.MissionCommandService;
import com.umc.workbook_zero.service.MissionService.MissionQueryService;
import com.umc.workbook_zero.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/challenge")
    @Operation(summary = "미션 도전하기 API", description = "memberId의 멤버가 missionId의 미션을 도전합니다.")
    public ApiResponse<ChallengeMissionResponse> challengeMission(
            @Valid @RequestBody ChallengeMissionRequest request
    ) {
        ChallengeMissionResponse response = missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/my/challenging")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "본인이 진행중인 미션 목록을 조회합니다.")
    public ApiResponse<List<ChallengingMissionResponse>> getMyChallengingMissions(
            @RequestHeader("X-MEMBER-ID") Long memberId,
            @ValidPage Integer page
    ) {
        List<ChallengingMissionResponse> responses = missionQueryService.getMyChallengingMissions(memberId, page);
        return ApiResponse.onSuccess(responses);
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정한 한 가게의 미션 목록을 조회합니다.")
    public ApiResponse<List<StoreMissionResponse>> getMissionsByStore(
            @PathVariable Long storeId,
            @ValidPage Integer page
    ) {
        List<StoreMissionResponse> responses = missionQueryService.getMissionsByStoreId(storeId, page);
        return ApiResponse.onSuccess(responses);
    }
}