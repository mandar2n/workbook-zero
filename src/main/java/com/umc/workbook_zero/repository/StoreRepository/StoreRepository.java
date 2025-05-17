package com.umc.workbook_zero.repository.StoreRepository;

import com.umc.workbook_zero.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
