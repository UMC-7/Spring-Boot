package umm.spring.study.service.ReviewService;

import umm.spring.study.domain.Review;
import umm.spring.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDTO request);
}
