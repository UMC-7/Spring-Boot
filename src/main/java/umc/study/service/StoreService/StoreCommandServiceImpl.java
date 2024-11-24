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
        // 1. regionId로 Region 엔티티 조회
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Region not found with ID: " + regionId));

        // 2. 요청 DTO를 Store 엔티티로 변환
        Store store = StoreConverter.toStoreEntity(request, region);

        // 3. Store 엔티티 저장
        Store savedStore = storeRepository.save(store);

        // 4. 저장된 Store 엔티티를 응답 DTO로 변환
        return StoreConverter.toAddStoreResultDTO(savedStore);
    }
}