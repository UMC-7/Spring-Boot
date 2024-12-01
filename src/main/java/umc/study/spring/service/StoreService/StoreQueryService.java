package umc.study.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoreByNameAndScore(String name,Float score);

    Page<Review> getReviewList(Long StoreId,Integer page);
}
