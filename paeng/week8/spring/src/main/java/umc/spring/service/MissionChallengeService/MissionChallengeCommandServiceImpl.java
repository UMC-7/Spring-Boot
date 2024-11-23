package umc.spring.service.MissionChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionChallengeRequestDTO;
import umc.spring.web.dto.MissionChallengeResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionChallengeCommandServiceImpl implements MissionChallengeCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MissionChallengeResponseDTO challengeMission(MissionChallengeRequestDTO request) {
        // Mission 조회
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 미션을 찾을 수 없습니다."));

        // Member 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버를 찾을 수 없습니다."));

        // 이미 도전 중인지 확인
        if (memberMissionRepository.existsByMemberIdAndMissionId(member.getId(), mission.getId())) {
            throw new IllegalStateException("이미 해당 미션에 도전 중입니다.");
        }

        // MemberMission 생성
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 기본 상태 설정
                .build();

        // 저장
        MemberMission savedMission = memberMissionRepository.save(memberMission);

        // DTO 변환 후 반환
        return MissionChallengeResponseDTO.builder()
                .memberMissionId(savedMission.getId())
                .memberId(savedMission.getMember().getId())
                .missionId(savedMission.getMission().getId())
                .status(savedMission.getStatus().name())
                .build();
    }
}
