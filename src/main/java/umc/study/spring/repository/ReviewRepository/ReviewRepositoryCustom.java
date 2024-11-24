package umc.study.spring.repository.ReviewRepository;

import umc.study.spring.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreName(String storeName);
}