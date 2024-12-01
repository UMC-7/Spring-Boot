package umc.study.repository.StoreReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;
import umc.study.domain.Store;

public interface StoreReviewRepository extends JpaRepository<Review, Long> {
   Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}