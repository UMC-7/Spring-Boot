package umc.study.spring.service.MemberService;

import umc.study.spring.domain.Member;
import umc.study.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
