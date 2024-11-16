package umc.spring.study.domain;

import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.mapping.MemberFood;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private final List<MemberFood> MemberFoodList = new ArrayList<>();
}