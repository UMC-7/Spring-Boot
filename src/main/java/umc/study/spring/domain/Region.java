package umc.study.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private List<Store> storeList=new ArrayList<>();

}
