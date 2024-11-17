package UMC._th.service;

import UMC._th.domain.Member;
import UMC._th.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDTO request);
}
