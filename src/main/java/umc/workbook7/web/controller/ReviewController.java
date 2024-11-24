package umc.workbook7.web.controller;

import umc.workbook7.web.dto.Review.ReviewResponseDTO;
import umc.workbook7.converter.ReviewConverter;
import umc.workbook7.web.dto.Review.ReviewRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.domain.entity.Review;
import umc.workbook7.service.Review.ReviewCommandService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    // 가게에 리뷰 생성
    @PostMapping(value = "/")//, consumes = "multipart/form-data")
    @Operation(summary = "리뷰 생성", description = "Review를 생성합니다.")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> reviewCreate(
            @RequestParam(name = "memberId") Long memberId,
            @RequestBody ReviewRequestDTO.CreateReviewRequestDTO request
            //@ModelAttribute ReviewRequestDTO.CreateReviewRequestDTO request
    )
    {
        Review newReview = reviewCommandService.createReview(memberId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Review_OK,
                ReviewConverter.toCreateResultDTO(newReview)
        );
    }



}
