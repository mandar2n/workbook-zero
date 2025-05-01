package com.umc.workbook_zero.repository.StoreRepository;

import com.umc.workbook_zero.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
