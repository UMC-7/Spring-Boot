package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.converter.StoreReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long storeId, Integer page);
}