package umc.spring.repository.ratingRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.common.QRating;
import umc.spring.domain.common.Rating;

@Repository
@RequiredArgsConstructor
public class RatingRepositoryImpl implements RatingRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QRating rating = QRating.rating;

}
