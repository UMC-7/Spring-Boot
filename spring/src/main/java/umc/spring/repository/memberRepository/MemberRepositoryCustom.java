package umc.spring.repository.memberRepository;

import umc.spring.domain.Member;

public interface MemberRepositoryCustom {

    Member findMemberById(Long id);


}
