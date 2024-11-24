package umc.workbook7.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.workbook7.converter.StoreConverter;
import umc.workbook7.domain.entity.Region;
import umc.workbook7.domain.entity.Store;
import umc.workbook7.repository.RegionRepository;
import umc.workbook7.repository.StoreRepository;
import umc.workbook7.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public Store createStore(Long regionId, StoreRequestDTO.CreateStoreRequestDTO request) {

        Store newStore = StoreConverter.toStore(request);
        Region getRegion = regionRepository.findById(regionId).get();
        newStore.setRegion(getRegion);
        Store savedStore = storeRepository.save(newStore);

        return savedStore;
    }
}