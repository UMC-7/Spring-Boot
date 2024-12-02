package UMC._th.domain;

import UMC._th.domain.common.BaseEntity;
import UMC._th.domain.enums.Agreement;
import UMC._th.domain.enums.Gender;
import UMC._th.domain.enums.MemberStatus;
import UMC._th.domain.enums.Role;
import UMC._th.domain.mapping.Home;
import UMC._th.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birth;

    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'AGREE'")
    private Agreement agreement;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private ArrayList<Home> homes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> prefers = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private ArrayList<Review> reviews = new ArrayList<>();

    public void encodePassword(String password){
        this.password=password;
    }
}
