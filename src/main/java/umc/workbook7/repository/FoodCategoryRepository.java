package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}