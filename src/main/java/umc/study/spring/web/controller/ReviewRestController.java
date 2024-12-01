package umc.study.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayload.ApiResponse;
import umc.study.spring.converter.ReviewConverter;
import umc.study.spring.domain.Review;
import umc.study.spring.service.ReviewService.ReviewCommandService;
import umc.study.spring.web.dto.ReviewRequestDTO;
import umc.study.spring.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddDTO request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }
}
