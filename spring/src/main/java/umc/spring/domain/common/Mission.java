package umc.spring.domain.common;

import jakarta.persistence.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String missionName;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @Column(length = 10)
    private String missionCertificationNumber;

    private Integer gotPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMisssion = new ArrayList<>();
}
