package umm.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umm.spring.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
