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
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    private Region region;

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList=new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }

}
