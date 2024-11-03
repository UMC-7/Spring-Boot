package UMC._th.domain;

import UMC._th.domain.common.BaseEntity;
import UMC._th.domain.enums.Agreement;
import UMC._th.domain.enums.Gender;
import UMC._th.domain.enums.MemberStatus;
import UMC._th.domain.mapping.Home;
import UMC._th.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birth;

    private String address;

    @Enumerated(EnumType.STRING)
    private Agreement agreement;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private ArrayList<Home> homes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private ArrayList<MemberPrefer> prefers = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private ArrayList<Review> reviews = new ArrayList<>();
}
