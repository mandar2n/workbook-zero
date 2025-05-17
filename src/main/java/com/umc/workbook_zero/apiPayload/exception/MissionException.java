package com.umc.workbook_zero.apiPayload.exception;

import com.umc.workbook_zero.apiPayload.code.BaseErrorCode;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
