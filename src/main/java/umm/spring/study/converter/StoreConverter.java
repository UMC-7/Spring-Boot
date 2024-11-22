

package umm.spring.study.converter;

import umm.spring.study.domain.Region;
import umm.spring.study.domain.Store;
import umm.spring.study.web.dto.StoreRequestDTO;
import umm.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store){
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createAt(LocalDateTime.now())
                .storeName(store.getName())
                .regionName(store.getRegion().getName())
                .storeScore(store.getScore())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddDTO request, Region region){
        return Store.builder()
                .name(request.getStoreName())
                .score(request.getStoreScore())
                .address(request.getStoreAddress())
                .region(region)
                .build();

    }
}
