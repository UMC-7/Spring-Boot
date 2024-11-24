package umc.workbook7.service.StoreService;

import umc.workbook7.domain.entity.Store;
import umc.workbook7.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(Long regionId, StoreRequestDTO.CreateStoreRequestDTO request);
}
