package umc.workbook7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook7.domain.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
