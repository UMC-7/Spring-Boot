package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.StoreReviewService.StoreReviewCommandService;
import umc.study.web.dto.StoreReviewRequestDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/{storeId}/members/{memberId}/reviews")
public class StoreReviewRestController {

    private final StoreReviewCommandService reviewCommandService;

    @PostMapping
    public ApiResponse<StoreReviewResponseDTO.AddReviewResultDTO> addReview(
            @PathVariable("storeId") Long storeId,
            @PathVariable("memberId") Long memberId,
            @RequestBody @Valid StoreReviewRequestDTO.AddReviewDTO request) {

        return ApiResponse.onSuccess(reviewCommandService.addReview(storeId, memberId, request));
    }
}