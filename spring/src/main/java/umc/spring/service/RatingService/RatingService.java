package umc.spring.service.RatingService;

import umc.spring.domain.common.Rating;
import umc.spring.web.dto.RatingDTO;

public interface RatingService {

    public Rating createRating(RatingDTO.CreateRating request);
}
