package umm.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umm.spring.study.apiPayload.ApiResponse;
import umm.spring.study.converter.ReviewConverter;
import umm.spring.study.domain.Review;
import umm.spring.study.service.ReviewService.ReviewCommandService;
import umm.spring.study.web.dto.ReviewRequestDTO;
import umm.spring.study.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }
}
