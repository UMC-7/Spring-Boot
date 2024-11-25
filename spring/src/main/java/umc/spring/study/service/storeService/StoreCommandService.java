package umc.spring.study.service.storeService;

import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService{
    Store addStore(Long regionId, StoreRequestDTO.AddStoreDTO request);
}
