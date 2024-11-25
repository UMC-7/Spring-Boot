package umc.spring.study.domain;

import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.mapping.MemberTerm;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private final List<MemberTerm> memberTermList = new ArrayList<>();
}