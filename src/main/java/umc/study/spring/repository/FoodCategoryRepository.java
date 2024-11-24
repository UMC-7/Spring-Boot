package umc.study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
