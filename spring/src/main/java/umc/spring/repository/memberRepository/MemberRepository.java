package umc.spring.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.common.Member;


public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
