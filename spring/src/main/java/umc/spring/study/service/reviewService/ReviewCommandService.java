package umc.spring.study.service.reviewService;

import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(Long memberId, Long storeId, ReviewRequestDTO.AddReviewDTO request);
}
