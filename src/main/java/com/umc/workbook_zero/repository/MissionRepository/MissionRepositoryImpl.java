package com.umc.workbook_zero.repository.MissionRepository;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.MissionException;
import com.umc.workbook_zero.domain.Mission;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final EntityManager em;

    @Override
    public Mission findMissionbyId(Long missionId) {
        Mission mission = em.find(Mission.class, missionId);
        if (mission == null) {
            throw new MissionException(ErrorStatus.MISSION_NOT_FOUND);
        }
        return mission;
    }
}