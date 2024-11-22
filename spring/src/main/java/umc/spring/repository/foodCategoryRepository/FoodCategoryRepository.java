package umc.spring.repository.foodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
