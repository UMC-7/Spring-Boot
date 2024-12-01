package umc.study.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.spring.domain.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;



}
