package com.umc.workbook_zero.repository.MissionRepository;

import com.umc.workbook_zero.domain.Mission;

public interface MissionRepositoryCustom {
    Mission findMissionbyId(Long missionId);
}
