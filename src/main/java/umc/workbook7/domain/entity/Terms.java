package umc.workbook7.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook7.domain.common.BaseEntity;
import umc.workbook7.domain.entity.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Column(nullable = false, length = 20)
    private String title;

    private String body;

    private Boolean optional;

    // created_at, updated_at in BaseEntity

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}


