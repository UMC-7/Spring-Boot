package umm.spring.study.service.StoreService;

import org.springframework.data.domain.Page;
import umm.spring.study.domain.Review;
import umm.spring.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
