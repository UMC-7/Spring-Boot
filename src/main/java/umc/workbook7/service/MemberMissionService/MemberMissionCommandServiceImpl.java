package umc.workbook7.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook7.converter.MemberMissionConverter;
import umc.workbook7.domain.entity.Member;
import umc.workbook7.domain.entity.Mission;
import umc.workbook7.domain.entity.mapping.MemberMission;
import umc.workbook7.repository.MemberMissionRepository;
import umc.workbook7.repository.MemberRepository;
import umc.workbook7.repository.MissionRepository;
import umc.workbook7.web.dto.MemberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission createMemberMission(Long missionId, MemberMissionRequestDTO.CreateMemberMissionRequestDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }
}