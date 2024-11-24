package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStoreEntity(StoreRequestDTO.AddStoreDTO request, Region region) {
        return Store.builder()
                .name(request.getStoreName())
                .address(request.getStoreAddress())
                .score(request.getStoreScore())
                .region(region).build();
    }

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .regionName(store.getRegion().getName()) // Region의 이름 가져오기
                .storeScore(store.getScore())
                .build();
    }
}
