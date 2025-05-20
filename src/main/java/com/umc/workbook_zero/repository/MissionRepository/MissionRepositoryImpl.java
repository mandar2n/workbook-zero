package com.umc.workbook_zero.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.MissionException;
import com.umc.workbook_zero.domain.Mission;
import com.umc.workbook_zero.domain.QMission;
import com.umc.workbook_zero.domain.enums.MissionStatus;
import com.umc.workbook_zero.domain.mapping.QMemberMission;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public Mission findMissionbyId(Long missionId) {
        Mission mission = em.find(Mission.class, missionId);
        if (mission == null) {
            throw new MissionException(ErrorStatus.MISSION_NOT_FOUND);
        }
        return mission;
    }

    @Override
    public Page<Mission> findChallengingMissionsByMemberId(Long memberId, Pageable pageable) {
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;

        List<Mission> missions = queryFactory
                .selectFrom(mission)
                .join(mission.memberMissionList, memberMission)
                .where(memberMission.member.memberId.eq(memberId), memberMission.status.eq(MissionStatus.CHALLENGING))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.createdAt.desc())
                .fetch();

        Long total = queryFactory
                .select(mission.count())
                .from(mission)
                .join(mission.memberMissionList, memberMission)
                .where(memberMission.member.memberId.eq(memberId), memberMission.status.eq(MissionStatus.CHALLENGING))
                .fetchOne();

        return new PageImpl<>(missions, pageable, total);
    }
}