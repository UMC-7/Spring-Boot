package umc.spring.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDTO toAddReviewDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder().
                reviewId(review.getId()).
                createdAt(LocalDateTime.now()).
                build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDTO request){
        return Review.builder().
                title(request.getTitle()).
                score(request.getScore()).
                build();
    }
}
