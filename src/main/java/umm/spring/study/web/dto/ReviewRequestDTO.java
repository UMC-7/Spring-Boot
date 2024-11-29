package umm.spring.study.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umm.spring.study.domain.Member;
import umm.spring.study.domain.Store;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDTO{

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
