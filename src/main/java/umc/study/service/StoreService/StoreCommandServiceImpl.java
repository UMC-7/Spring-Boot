package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreResponseDTO.AddStoreResultDTO AddStoreDTO(Long regionId, StoreRequestDTO.AddStoreDTO request) {

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Region not found with ID: " + regionId));

        Store store = StoreConverter.toStoreEntity(request, region);

        Store savedStore = storeRepository.save(store);

        return StoreConverter.toAddStoreResultDTO(savedStore);
    }
}