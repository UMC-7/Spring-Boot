package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Rating;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberComandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findById(Long id);

    Page<Rating> getRatingList(Long memberId, Integer page);
}
