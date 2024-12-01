package umc.spring.repository.missionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.domain.common.Store;
import umc.spring.domain.mapping.MemberMission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    Page<Mission> findAllByStore(Store store, PageRequest request);


}
