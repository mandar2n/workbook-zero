package com.umc.workbook_zero.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddMissionResponse {
    private Long missionId;
    private String message;
}