package umc.workbook7.service.MemberService;

import umc.workbook7.domain.entity.Member;
import umc.workbook7.web.dto.Member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
