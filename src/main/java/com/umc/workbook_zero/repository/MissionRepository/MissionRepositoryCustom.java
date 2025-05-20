package com.umc.workbook_zero.repository.MissionRepository;

import com.umc.workbook_zero.domain.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepositoryCustom {
    Mission findMissionbyId(Long missionId);
    Page<Mission> findChallengingMissionsByMemberId(Long memberId, Pageable pageable);
}
