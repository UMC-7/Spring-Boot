package UMC._th.domain.mapping;

import UMC._th.domain.FoodPrefer;
import UMC._th.domain.Member;
import UMC._th.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_prefer_id")
    private FoodPrefer foodPrefer;

    public void setMember(Member member){
        if(this.member != null)
            member.getPrefers().remove(this);
        this.member=member;
        member.getPrefers().add(this);
    }
}
