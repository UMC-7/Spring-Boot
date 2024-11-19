package umc.workbook7.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook7.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImageId;

    //private Long reviewId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    private String imageUrl;

    // ReviewImage 엔티티에 추가
    public void setReview(Review review) {
        this.review = review;
    }

    // created_at, updated_at in BaseEntity
}

