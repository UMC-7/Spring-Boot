package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.domain.common.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.ratingRepository.RatingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final RatingRepository ratingRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Rating> getRatingList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Rating> StorePage = ratingRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();
        Page<Mission> allByStore = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return allByStore;
    }
}
