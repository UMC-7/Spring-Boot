package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
