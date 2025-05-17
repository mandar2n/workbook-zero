package com.umc.workbook_zero.service.StoreService;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.StoreException;
import com.umc.workbook_zero.converter.MissionConverter;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.domain.Store;
import com.umc.workbook_zero.dto.request.AddMissionRequest;
import com.umc.workbook_zero.dto.response.AddMissionResponse;
import com.umc.workbook_zero.repository.MissionRepository.MissionRepository;
import com.umc.workbook_zero.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;

    @Override
    public AddMissionResponse addMission(Long storeId, AddMissionRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = missionConverter.toEntity(request, store);
        Mission savedMission = missionRepository.save(mission);

        return new AddMissionResponse(savedMission.getMissionId(), "미션이 성공적으로 추가되었습니다.");
    }
}