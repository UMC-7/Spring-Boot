package umc.workbook7.converter;

import umc.workbook7.domain.entity.Review;
import umc.workbook7.web.dto.Review.ReviewRequestDTO;
import umc.workbook7.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewRequestDTO request){
        return Review.builder()
                .review(request.getReview())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createAt(review.getCreatdAt())
                .build();
    }
}
