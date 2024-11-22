package umm.spring.study.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umm.spring.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
