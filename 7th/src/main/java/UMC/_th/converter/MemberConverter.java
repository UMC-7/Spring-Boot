package UMC._th.converter;

import UMC._th.domain.Member;
import UMC._th.domain.enums.Gender;
import UMC._th.web.dto.MemberRequestDTO;
import UMC._th.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return Member.builder()
                .address(request.getAddress()+" "+request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .prefers(new ArrayList<>())
                .build();
    }
}