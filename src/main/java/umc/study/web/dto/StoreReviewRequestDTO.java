package umc.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreReviewRequestDTO {

    @Getter
    public static class AddReviewDTO {

        @Min(0)
        @Max(5)
        Float score;

        @NotBlank
        String title;

        @NotBlank
        String content;
    }
}