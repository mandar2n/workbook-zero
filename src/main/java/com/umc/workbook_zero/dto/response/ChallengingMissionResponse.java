package com.umc.workbook_zero.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengingMissionResponse {
    private Long missionId;
    private String storeName;
    private String missionSpec;
    private Integer reward;
    private LocalDate deadline;
}
