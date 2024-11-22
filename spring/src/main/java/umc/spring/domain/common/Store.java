package umc.spring.domain.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String storeName;

    @Column(length = 10)
    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @Column(name = "avg_rating")
    private Float avgRating;

    @Column(length = 10)
    private String storeType;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private String operationState;

    private LocalTime operationTime;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + storeName + '\'' +
                ", score=" + avgRating;
    }
}