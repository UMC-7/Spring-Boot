package umc.study.repository.StoreReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;

public interface StoreReviewRepository extends JpaRepository<Review, Long> {
}