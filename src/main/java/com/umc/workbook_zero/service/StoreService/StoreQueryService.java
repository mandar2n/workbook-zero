package com.umc.workbook_zero.service.StoreService;

import com.umc.workbook_zero.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}