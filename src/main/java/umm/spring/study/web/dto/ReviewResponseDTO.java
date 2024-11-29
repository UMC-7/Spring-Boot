package umm.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umm.spring.study.domain.Member;
import umm.spring.study.domain.ReviewImage;
import umm.spring.study.domain.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
