package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
