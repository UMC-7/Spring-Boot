package UMC._th.domain;

import UMC._th.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodPrefer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String category;

    //@OneToMany(mappedBy = "foodPrefer", cascade = CascadeType.ALL)
    //private ArrayList<MemberPrefer> prefers = new ArrayList<>();
}
