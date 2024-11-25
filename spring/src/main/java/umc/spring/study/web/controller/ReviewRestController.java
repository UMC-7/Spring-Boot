package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.service.reviewService.ReviewCommandService;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> addReview(
            @RequestParam Long memberId, // Query로 memberId 받기
            @RequestParam Long storeId,  // Query로 storeId 받기
            @RequestBody @Valid ReviewRequestDTO.AddReviewDTO request // Body로 요청 데이터 받기
    ) {
        // 서비스 계층 호출
        Review review = reviewCommandService.addReview(memberId, storeId, request);

        // 응답 DTO 변환 및 반환
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewDTO(review));
    }
}
