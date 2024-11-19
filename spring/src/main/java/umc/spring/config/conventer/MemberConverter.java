package umc.spring.config.conventer;

import umc.spring.domain.common.Member;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
