package umc.study.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.converter.StoreConverter;
import umc.study.spring.domain.Region;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.RegionRepository.RegionRepository;
import umc.study.spring.repository.StoreRepository.StoreRepository;
import umc.study.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private  final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDTO request){
        Region region = regionRepository.findByName(request.getRegionName());

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
