package umm.spring.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umm.spring.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
