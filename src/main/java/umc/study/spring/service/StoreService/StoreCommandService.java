package umc.study.spring.service.StoreService;

import umc.study.spring.domain.Store;
import umc.study.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddDTO request);
}
