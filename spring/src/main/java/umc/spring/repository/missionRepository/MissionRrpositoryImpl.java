package umc.spring.repository.missionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.QMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRrpositoryImpl implements MissionRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findMissionByMemberAndFinishPaging(Member member, Long cursor) {
        return null;
    }

    @Override
    public List<Mission> findMissionByMemberAndComplete(Member member) {

        Long id = member.getId();

        return jpaQueryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(
                        memberMission.member.id.eq(id)
                                .and(mission.status.eq(String.valueOf(MissionStatus.COMPLETE)))
                )
                .fetch();

    }

    @Override
    public List<Mission> findMissionByMemberAndTrying(Member member) {

        Long id = member.getId();

        return jpaQueryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(
                        memberMission.member.id.eq(id)
                                .and(mission.status.eq(String.valueOf(MissionStatus.TRYING)))
                )
                .fetch();
    }
}
