package umc.spring.repository.missionRepository;

import com.querydsl.core.types.dsl.Expressions;
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
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findMissionByMemberAndCompletePaging(Member member, Long cursor) {

        Long id = member.getId();

        return jpaQueryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(
                        memberMission.member.id.eq(id)
                                .and(mission.status.eq(String.valueOf(MissionStatus.COMPLETE)))
                                .and(
                                        Expressions.stringTemplate(
                                                "CONCAT(LPAD({0}, 10, '0'), LPAD({1}, 10, '0'))",
                                                mission.createdAt,
                                                mission.id
                                        ).lt(String.valueOf(cursor))
                                )
                )
                .orderBy(mission.createdAt.desc(), mission.id.desc())
                .limit(15)
                .fetch();
    }

    @Override
    public List<Mission> findMissionByMemberAndTryingPaging(Member member, Long cursor) {

        Long id = member.getId();

        return jpaQueryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(
                        memberMission.member.id.eq(id)
                                .and(mission.status.eq(String.valueOf(MissionStatus.TRYING)))
                                .and(
                                        Expressions.stringTemplate(
                                                "CONCAT(LPAD({0}, 10, '0'), LPAD({1}, 10, '0'))",
                                                mission.createdAt,
                                                mission.id
                                        ).lt(String.valueOf(cursor))
                                )
                )
                .orderBy(mission.createdAt.desc(), mission.id.desc())
                .limit(15)
                .fetch();
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
                .orderBy(mission.createdAt.desc(), mission.id.desc())
                .limit(15)
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
                .orderBy(mission.createdAt.desc(), mission.id.desc())
                .limit(15)
                .fetch();
    }
}
