package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository; // StoreRepository 추가


    public MissionCommandServiceImpl(MissionRepository missionRepository,
                                    StoreRepository storeRepository) {
        this.missionRepository = missionRepository;
        this.storeRepository = storeRepository;
    }
    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.MCreateDto request) {

        // Store 조회
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + request.getStoreId()));

        // Mission 생성
        Mission newMission = MissionConverter.toMission(request, store);

        // Mission 저장
        return missionRepository.save(newMission);
    }
}
