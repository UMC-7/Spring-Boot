package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.StoreMissionRepository;

@Service
@RequiredArgsConstructor
public class StoreMissionQueryService {

    private final StoreMissionRepository missionRepository;

    public Page<Mission> getStoreMissions(Long storeId, int page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        return missionRepository.findAllByStoreId(storeId, pageRequest);
    }
}