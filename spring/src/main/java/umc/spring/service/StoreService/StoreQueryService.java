package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.domain.common.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Rating> getRatingList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}