package com.umc.workbook_zero.dto.request;

import com.umc.workbook_zero.validation.annotation.ExistsStore;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReviewRequest {

    @ExistsStore
    private Long storeId;

    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotNull(message = "점수는 필수입니다.")
    @DecimalMin(value = "0.0", message = "점수는 0 이상이어야 합니다.")
    @DecimalMax(value = "5.0", message = "점수는 5 이하여야 합니다.")
    private Float score;

    @NotBlank(message = "내용은 필수입니다.")
    private String body;
}