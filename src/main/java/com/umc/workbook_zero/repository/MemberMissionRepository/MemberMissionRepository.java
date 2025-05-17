package com.umc.workbook_zero.repository.MemberMissionRepository;

import com.umc.workbook_zero.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umc.workbook_zero.domain.enums.MissionStatus;


import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // 특정 사용자가 특정 미션을 CHALLENGING 상태로 도전 중인지 확인
    boolean existsByMember_MemberIdAndMission_MissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);

    // 나중에 도전 내역 조회 등에 사용 가능
    List<MemberMission> findByMember_MemberId(Long memberId);
}
