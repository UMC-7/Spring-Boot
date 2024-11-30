package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.config.conventer.RatingConverter;
import umc.spring.domain.common.Rating;
import umc.spring.service.RatingService.RatingService;
import umc.spring.web.dto.RatingRequestDTO;
import umc.spring.web.dto.RatingResponseDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingRestController {

    private final RatingService ratingService;

    @PostMapping("/create")
    public ApiResponse<RatingResponseDTO.JoinResultDTO> createRating(@Valid @RequestBody RatingRequestDTO.CreateRating request) {
        Rating rating = ratingService.createRating(request);
        return ApiResponse.onSuccess(RatingConverter.toCreateResultDTO(rating));
    }
}
