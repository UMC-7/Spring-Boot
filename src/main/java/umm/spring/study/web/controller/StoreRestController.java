package umm.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umm.spring.study.apiPayload.ApiResponse;
import umm.spring.study.converter.StoreConverter;
import umm.spring.study.domain.Store;
import umm.spring.study.service.StoreService.StoreCommandService;
import umm.spring.study.web.dto.StoreRequestDTO;
import umm.spring.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private  final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDTO> join(@RequestBody @Valid StoreRequestDTO.AddDTO request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

}
