package umc.study.spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
