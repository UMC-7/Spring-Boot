package umc.spring.config.conventer;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.common.Rating;
import umc.spring.web.dto.RatingRequestDTO;
import umc.spring.web.dto.RatingResponseDTO;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class RatingConverter {

    public static RatingResponseDTO.JoinResultDTO toCreateResultDTO(Rating rating) {
        return RatingResponseDTO.JoinResultDTO.builder()
                .ratingId(rating.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Rating toRating(RatingRequestDTO.CreateRating request) {

        return Rating.builder()
                .rate(request.getRate())
                .ratingContent(request.getRatingContent())
                .build();
    }
}
