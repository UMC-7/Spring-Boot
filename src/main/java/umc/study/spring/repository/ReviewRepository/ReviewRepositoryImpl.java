package umc.study.spring.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.spring.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Review> findReviewsByStoreName(String storeName) {
        String jpql = "SELECT r FROM Review r WHERE r.store.name = :storeName";
        return entityManager.createQuery(jpql, Review.class)
                .setParameter("storeName", storeName)
                .getResultList();
    }
}
