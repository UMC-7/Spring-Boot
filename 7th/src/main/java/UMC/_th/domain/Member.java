package UMC._th.domain;

import UMC._th.domain.common.BaseEntity;
import UMC._th.domain.enums.Agreement;
import UMC._th.domain.enums.Gender;
import UMC._th.domain.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.*;

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
}
