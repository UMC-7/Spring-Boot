package umm.spring.study.service.MemberService;

import umm.spring.study.domain.Member;
import umm.spring.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
