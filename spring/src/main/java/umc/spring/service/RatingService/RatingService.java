package umc.spring.service.RatingService;

import umc.spring.domain.common.Rating;
import umc.spring.web.dto.RatingRequestDTO;

public interface RatingService {

    public Rating createRating(RatingRequestDTO.CreateRating request);
}
