package umc.study.spring.service.ReviewService;

import umc.study.spring.domain.Review;
import umc.study.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddDTO request);
}
