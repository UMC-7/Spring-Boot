package umc.spring.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StoreConverter {
    public static StoreResponseDTO.StoreResultDTO toAddStoreDTO(Store store){
        return StoreResponseDTO.StoreResultDTO.builder().
                storeId(store.getId()).
                createdAt(LocalDateTime.now()).
                build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDTO request){
        return Store.builder().
                name(request.getName()).
                address(request.getAddress()).
                build();
    }
}
