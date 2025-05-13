package com.umc.workbook_zero.apiPayload.exception.handler;

import com.umc.workbook_zero.apiPayload.code.BaseErrorCode;
import com.umc.workbook_zero.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}