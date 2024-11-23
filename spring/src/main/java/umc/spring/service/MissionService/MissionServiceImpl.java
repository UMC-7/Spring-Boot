package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.config.conventer.MissionConverter;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Store;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.MissionDTO;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionService missionService;
    private final StoreQueryService storeQueryService;

    @Override
    @Transactional
    public Mission addMission(MissionDTO.AddDTO request) {

        Mission newMission = MissionConverter.toMission(request);

        Optional<Store> store = storeQueryService.findStore(request.getStoreId());

        Store storeValue = store.orElseThrow(() -> new IllegalArgumentException("Store 값이 없습니다."));
        newMission.setStore(storeValue);

        return newMission;
    }
}
