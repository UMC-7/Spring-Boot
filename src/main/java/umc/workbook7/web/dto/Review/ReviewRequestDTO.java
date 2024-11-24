package umc.workbook7.web.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

public class ReviewRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReviewRequestDTO {
        private Long storeId;
        private String review;
        private Float score;
        //private MultipartFile reviewPicture; // 리뷰에 사진도 추기
    }









}
