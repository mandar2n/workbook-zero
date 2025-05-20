package com.umc.workbook_zero.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreMissionResponse {
    private Long missionId;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
