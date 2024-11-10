package umc.spring.repository.ratingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {
}
