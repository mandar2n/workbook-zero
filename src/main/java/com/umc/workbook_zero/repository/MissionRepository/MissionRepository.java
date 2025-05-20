package com.umc.workbook_zero.repository.MissionRepository;

import com.umc.workbook_zero.domain.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    Page<Mission> findByStore_StoreId(Long storeId, Pageable pageable);
}

