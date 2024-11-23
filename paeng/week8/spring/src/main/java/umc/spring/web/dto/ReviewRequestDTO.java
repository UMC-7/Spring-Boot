package umc.spring.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    @Setter
    public static class CreateDto {
        private String title; // 리뷰 제목
        private Float score; // 점수
        private Long memberId; // 작성자 ID
        private Long storeId; // 가게 ID
    }
}
