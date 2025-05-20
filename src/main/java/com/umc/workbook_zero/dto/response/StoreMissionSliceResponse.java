package com.umc.workbook_zero.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreMissionSliceResponse {
    private List<StoreMissionResponse> missions;
    private boolean hasNext;
}