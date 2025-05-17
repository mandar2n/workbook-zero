package com.umc.workbook_zero.dto.request;

import com.umc.workbook_zero.validation.annotation.NotAlreadyChallenged;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@NotAlreadyChallenged
@Getter
public class ChallengeMissionRequest {

    @NotNull
    private Long memberId;

    @NotNull
    private Long missionId;
}
