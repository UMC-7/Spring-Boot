package umc.spring.repository.memberRepository;

import umc.spring.domain.common.Member;

public interface MemberRepositoryCustom {

    Member findMemberById(Long id);


}
