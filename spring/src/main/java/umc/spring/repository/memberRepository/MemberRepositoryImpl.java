package umc.spring.repository.memberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member findMemberById(Long id) {

        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(id));

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetchOne();
    }
}
