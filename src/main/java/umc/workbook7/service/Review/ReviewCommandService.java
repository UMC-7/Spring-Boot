package umc.workbook7.service.Review;

import umc.workbook7.domain.entity.Review;
import umc.workbook7.web.dto.Review.ReviewRequestDTO;

import java.io.IOException;

public interface ReviewCommandService {
    Review createReview(Long memberId, ReviewRequestDTO.CreateReviewRequestDTO request); //throws IOException;
}
