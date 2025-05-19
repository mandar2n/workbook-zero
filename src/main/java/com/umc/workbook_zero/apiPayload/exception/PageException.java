package com.umc.workbook_zero.apiPayload.exception;

import com.umc.workbook_zero.apiPayload.code.BaseErrorCode;

public class PageException extends GeneralException {
    public PageException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}