package umc.spring.repository.missionRepository;

import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findMissionByMemberAndCompletePaging(Member member, Long cursor);

    List<Mission> findMissionByMemberAndTryingPaging(Member member, Long cursor);

    List<Mission> findMissionByMemberAndComplete(Member member);

    List<Mission> findMissionByMemberAndTrying(Member member);

    List<Mission> findMissionByLocationAndPossible(Member member, String location, Long cursor);

    List<MemberMission> findMissionByMemberAndLocation(Member member, String location);
}
