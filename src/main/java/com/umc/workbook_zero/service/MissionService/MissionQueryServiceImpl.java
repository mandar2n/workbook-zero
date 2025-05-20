package com.umc.workbook_zero.service.MissionService;

import com.umc.workbook_zero.converter.MissionConverter;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.dto.response.ChallengingMissionResponse;
import com.umc.workbook_zero.dto.response.StoreMissionResponse;
import com.umc.workbook_zero.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;

    @Override
    public List<ChallengingMissionResponse> getMyChallengingMissions(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Mission> missions = missionRepository.findChallengingMissionsByMemberId(memberId, pageable);
        return missionConverter.toChallengingMissionResponseList(missions.getContent());
    }

    @Override
    public List<StoreMissionResponse> getMissionsByStoreId(Long storeId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Mission> missions = missionRepository.findByStore_StoreId(storeId, pageable);
        return missionConverter.toStoreMissionResponseList(missions.getContent());
    }
}
