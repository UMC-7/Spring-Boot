package umc.spring.service.MemberService;

import umc.spring.domain.common.Member;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberComandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findById(Long id);
}
