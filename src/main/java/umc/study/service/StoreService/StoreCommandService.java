package umc.study.service.StoreService;


import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO.AddStoreResultDTO AddStoreDTO(Long regionId, StoreRequestDTO.AddStoreDTO request);
}