package com.umc.workbook_zero.validation.validator;

import com.umc.workbook_zero.repository.StoreRepository.StoreRepository;
import com.umc.workbook_zero.validation.annotation.ExistsStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistsStoreValidator implements ConstraintValidator<ExistsStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;
        return storeRepository.existsById(storeId);
    }
}

