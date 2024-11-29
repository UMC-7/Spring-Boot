package umm.spring.study.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umm.spring.study.converter.StoreConverter;
import umm.spring.study.domain.Region;
import umm.spring.study.domain.Store;
import umm.spring.study.repository.RegionRepository.RegionRepository;
import umm.spring.study.repository.StoreRepository.StoreRepository;
import umm.spring.study.web.dto.StoreRequestDTO;

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
