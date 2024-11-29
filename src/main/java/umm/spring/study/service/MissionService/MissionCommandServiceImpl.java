package umm.spring.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umm.spring.study.converter.MissionConverter;
import umm.spring.study.domain.Member;
import umm.spring.study.domain.Mission;
import umm.spring.study.domain.mapping.MemberMission;
import umm.spring.study.repository.MemberMissionRepository;
import umm.spring.study.repository.MemberRepository;
import umm.spring.study.repository.MissionRepository.MissionRepository;
import umm.spring.study.web.dto.MissionRequestDTO;

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
