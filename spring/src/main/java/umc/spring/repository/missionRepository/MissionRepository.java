package umc.spring.repository.missionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
