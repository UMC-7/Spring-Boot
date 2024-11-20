package umc.workbook7.domain.entity.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook7.domain.common.BaseEntity;
import umc.workbook7.domain.entity.Member;
import umc.workbook7.domain.entity.Mission;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberMissionId;

    //private Long memberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //private Long missionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    // created_at, updated_at in BaseEntity

    public void setMission(Mission mission) {
        this.mission = mission;
    }

}

