package umm.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umm.spring.study.domain.common.BaseEntity;
import umm.spring.study.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDate deadline;

    @Column(name = "mission_spec", columnDefinition = "TEXT")
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store storeId;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
