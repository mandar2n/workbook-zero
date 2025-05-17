package com.umc.workbook_zero.repository.MissionRepository;

import com.umc.workbook_zero.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {}

