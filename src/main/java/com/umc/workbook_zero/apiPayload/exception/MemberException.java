package com.umc.workbook_zero.apiPayload.exception;

import com.umc.workbook_zero.apiPayload.code.BaseErrorCode;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

