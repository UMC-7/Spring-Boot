package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.config.conventer.MemberMissionConverter;
import umc.spring.config.conventer.MissionConverter;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.service.MemberService.MemberComandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MemberComandService memberComandService;
    private final StoreQueryService storeQueryService;
    private final MissionService missionService;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission addMission(MissionDTO.AddDTO request) {

        Mission newMission = MissionConverter.toMission(request);

        Optional<Store> store = storeQueryService.findStore(request.getStoreId());


        Store storeValue = store.orElseThrow(() -> new IllegalArgumentException("Store 값이 없습니다."));
        newMission.setStore(storeValue);

        return newMission;
    }

    @Override
    public MemberMission addTryingMission(MissionDTO.AddTryDTO request) {

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);

        Optional<Member> targetMember = memberComandService.findById(request.getMemberId());
        Optional<Mission> targetMission = missionService.findById(request.getMissionId());

        Mission missionValue = targetMission.orElseThrow(() -> new IllegalArgumentException("Mission이 존재하지 않습니다"));
        Member MemberValue = targetMember.orElseThrow(() -> new IllegalArgumentException("Member 값이 존재하지 않습니다"));

        newMemberMission.setMember(MemberValue);
        newMemberMission.setMission(missionValue);

        return newMemberMission;
    }

    @Override
    public Optional<Mission> findById(Long id) {
        return missionRepository.findById(id);
    }
}
