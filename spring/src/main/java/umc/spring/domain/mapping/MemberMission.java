package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    public void setMember(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission) {
        this.mission = mission;
        mission.getMemberMisssion().add(this);
    }
}
