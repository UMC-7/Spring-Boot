package umm.spring.study.repository.ReviewRepository;

import umm.spring.study.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreName(String storeName);
}
