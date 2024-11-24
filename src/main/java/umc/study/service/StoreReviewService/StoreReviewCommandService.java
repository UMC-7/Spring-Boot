package umc.study.service.StoreReviewService;

import umc.study.web.dto.StoreReviewRequestDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

public interface StoreReviewCommandService {

    StoreReviewResponseDTO.AddReviewResultDTO addReview(Long storeId, Long memberId, StoreReviewRequestDTO.AddReviewDTO request);
}