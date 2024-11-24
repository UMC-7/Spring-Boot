package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}")
    public ApiResponse<StoreResponseDTO.AddStoreResultDTO> addStore(
            @PathVariable("regionId") Long regionId,
            @RequestBody @Valid StoreRequestDTO.AddStoreDTO request) {
        return ApiResponse.onSuccess(storeCommandService.AddStoreDTO(regionId, request));
    }
}