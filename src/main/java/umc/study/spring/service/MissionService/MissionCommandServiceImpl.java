package umc.study.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.Member;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.mapping.MemberMission;
import umc.study.spring.repository.MemberMissionRepository;
import umc.study.spring.repository.MemberRepository;
import umc.study.spring.repository.MissionRepository.MissionRepository;
import umc.study.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission addMissionToChallenge(MissionRequestDTO.AddChallengeDTO request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        MemberMission memberMission = MissionConverter.toMemberMission(member, mission);

        // 저장
        return memberMissionRepository.save(memberMission);
    }
}
