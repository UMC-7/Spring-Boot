package umc.spring.repository.ratingRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.common.QRating;

@Repository
@RequiredArgsConstructor
public class RatingRepositoryImpl implements RatingRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QRating rating = QRating.rating;

}
