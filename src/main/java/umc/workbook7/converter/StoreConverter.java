package umc.workbook7.converter;

import umc.workbook7.domain.entity.Store;
import umc.workbook7.web.dto.Store.StoreRequestDTO;
import umc.workbook7.web.dto.Store.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.CreateStoreRequestDTO request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getStoreId())
                .createAt(store.getCreatdAt())
                .build();
    }
}
