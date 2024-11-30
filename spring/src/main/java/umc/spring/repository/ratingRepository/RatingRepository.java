package umc.spring.repository.ratingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Rating;
import umc.spring.domain.common.Store;

public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {

    Page<Rating> findAllByStore(Store store, PageRequest pageRequest);

    Page<Rating> findAllByMember(Member member, PageRequest pageRequest);
}
