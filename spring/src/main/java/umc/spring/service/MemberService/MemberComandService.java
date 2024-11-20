package umc.spring.service.MemberService;

import umc.spring.domain.common.Member;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberComandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);
}
