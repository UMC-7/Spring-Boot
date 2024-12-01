package umc.study.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO {
        private Long reviewId;
        private String body;
        private Float score;
        private LocalDateTime createdAt;
        private String title;
        private Long memberId;
        private Long storeId;

    }
}