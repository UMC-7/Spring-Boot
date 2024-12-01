package umc.study.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class AddDTO{

        private String body;

        @NotNull
        @Min(value = 1)
        @Max(value = 5)
        private Float score;

        @NotBlank
        private String title;

        @NotNull
        private Long memberId;

        @NotNull
        private Long storeId;
    }
}