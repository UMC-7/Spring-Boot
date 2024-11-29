// DTO와 엔티티 객체 간 변환을 담당
// 즉, DTO 변수를 기반으로 객체로 만드는 메서드들의 집합

package umm.spring.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umm.spring.study.domain.Member;
import umm.spring.study.domain.enums.Gender;
import umm.spring.study.repository.MemberRepository;
import umm.spring.study.service.MemberService.MemberCommandService;
import umm.spring.study.web.dto.MemberRequestDTO;
import umm.spring.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberConverter {

    // Member 엔티티를 MemberResponseDTO.JoinResultDTO로 변환
    // API 응답에 필요한 데이터만 담는 DTO로 변환하는 역할을 함
    // 클라이언트 요청 바탕으로 데이터베이스에 저장된 것을 클라이언트에 응답으로 보내기 위한 작업
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 클라이언트 요청시 MemberCommandServiceImpl의 joinMember() 에서 여기를 호출
    // 클라이언트에서 전달받은 JoinDTO 요청 데이터를 기반으로 새로운 Member 엔티티 생성
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .age(2024-request.getBirthYear())
                .build();
    }
}
