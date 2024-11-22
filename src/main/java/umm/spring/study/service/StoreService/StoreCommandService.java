package umm.spring.study.service.StoreService;

import umm.spring.study.domain.Store;
import umm.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddDTO request);
}
