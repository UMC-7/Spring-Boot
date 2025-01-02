package UMC._th.service.StoreService;

import UMC._th.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findAllStoresByNameAndScore(String name, Float score);
}
