package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.config.conventer.RatingConverter;
import umc.spring.domain.common.Rating;
import umc.spring.service.MemberService.MemberComandService;
import umc.spring.service.RatingService.RatingService;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.RatingDTO;
import umc.spring.web.dto.RatingResponseDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingRestController {

    private final RatingService ratingService;


    public ApiResponse<RatingResponseDTO.JoinResultDTO> createRating(@Valid @RequestBody RatingDTO.CreateRating request) {
        Rating rating = ratingService.createRating(request);
        return ApiResponse.onSuccess(RatingConverter.toCreateResultDTO(rating));
    }
}
