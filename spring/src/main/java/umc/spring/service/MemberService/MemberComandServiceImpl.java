package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.common.Member;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.web.converter.MemberConverter;
import umc.spring.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberComandServiceImpl implements MemberComandService{

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        return null;
    }
}
