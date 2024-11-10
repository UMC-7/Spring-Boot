package umc.spring.repository.missionRepository;

import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findMissionByMemberAndFinishPaging(Member member, Long cursor);

    List<Mission> findMissionByMemberAndComplete(Member member);

    List<Mission> findMissionByMemberAndTrying(Member member);

}
