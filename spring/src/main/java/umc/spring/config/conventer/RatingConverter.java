package umc.spring.config.conventer;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.service.RatingService.RatingService;
import umc.spring.web.dto.RatingDTO;
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

    public static Rating toRating(RatingDTO.CreateRating request) {

        return Rating.builder()
                .rate(request.getRate())
                .ratingContent(request.getRatingContent())
                .build();
    }
}
