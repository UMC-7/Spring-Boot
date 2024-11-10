package umc.spring.repository.memberRepository;

import umc.spring.domain.common.Member;

public interface MemberRepositoryCustom {

    //맴버 추가
    Member findMemberById(Long id);


}
