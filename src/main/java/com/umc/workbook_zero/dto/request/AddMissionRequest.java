package com.umc.workbook_zero.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddMissionRequest {
    @NotNull(message = "_REWARD_REQUIRED")
    private Integer reward;

    @NotNull(message = "_DEADLINE_REQUIRED")
    private LocalDate deadline;

    @NotBlank(message = "_MISSION_SPEC_REQUIRED")
    private String missionSpec;
}