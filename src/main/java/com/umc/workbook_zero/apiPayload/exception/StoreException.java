package com.umc.workbook_zero.apiPayload.exception;

import com.umc.workbook_zero.apiPayload.code.BaseErrorCode;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
