package umc.study.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.spring.domain.QReview;
import umc.study.spring.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    @Override
    public List<Review> findReviewsByStoreName(String storeName){
        return jpaQueryFactory
                .selectFrom(review)
                .where(review.store.name.eq(storeName))
                .fetch();
    }
}
