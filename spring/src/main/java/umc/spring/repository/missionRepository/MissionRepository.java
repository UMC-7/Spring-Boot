package umc.spring.repository.missionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
