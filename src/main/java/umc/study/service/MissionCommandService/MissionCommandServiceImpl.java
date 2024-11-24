package umc.study.service.MissionCommandService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConvertor;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.service.MissionCommandService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO.AddMissionResultDTO addMission(Long storeId, MissionRequestDTO.AddMissionDTO request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));

        Mission newMission = MissionConvertor.toMissionEntity(request, store);

        Mission savedMission = missionRepository.save(newMission);

        return MissionConvertor.toAddMissionResultDTO(savedMission);
    }
}